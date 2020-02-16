package club.mikusun.iadmin.account.config;

import club.mikusun.iadmin.account.dao.AccessDao;
import club.mikusun.iadmin.account.shiro.filter.AccountFormAuthenticationFilter;
import club.mikusun.iadmin.account.shiro.Realm.AccountRealm;
import club.mikusun.iadmin.account.shiro.serializer.ShiroFastJsonRedisSerializer;
import club.mikusun.iadmin.cache.util.FastJsonRedisSerializer;
import club.mikusun.iadmin.domain.account.Access;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.crazycake.shiro.serializer.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;

import javax.servlet.Filter;
import java.util.*;

@Configuration
//@ConditionalOnBean(AccessDao.class)
public class ShiroConfig {

    @Autowired
    private AccessDao accessDao;
    /**
     * 开启aop注解支持,鉴权
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    // 传入shiro安全管理器
    @Bean
    @Order(5)
    public ShiroFilterFactoryBean shiroFilter( SecurityManager securityManager) {
        // Shiro过滤器创建工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 绑定安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 指定登录链接
        shiroFilterFactoryBean.setLoginUrl("/login");
        Map<String , Filter > shiroFiltersMap = new LinkedHashMap<>();
        shiroFiltersMap.put("authc" , new AccountFormAuthenticationFilter());
        shiroFilterFactoryBean.setFilters(shiroFiltersMap);

        // 指定没有权限时跳转的页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/login");

        List<Access> accesses = accessDao.findAll(Sort.by(Sort.Direction.DESC, "id"));
        // 权限认证链接map
        // TODO: 之后通过数据库动态导入
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        accesses.stream().forEach(v -> {
            filterChainDefinitionMap.put(v.getResource_url(), v.isOpened()?"anon":"authc");
        });
//        filterChainDefinitionMap.put("/account/**", "authc");
//        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
//        filterChainDefinitionMap.put("/**", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    @Order(4)
    public SecurityManager securityManager(AccountRealm accountRealm,CacheManager cacheManager , SessionManager sessionManager) {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setCacheManager(cacheManager);
        defaultSecurityManager.setRealm(accountRealm);
        defaultSecurityManager.setSessionManager(sessionManager);
        return defaultSecurityManager;
    }

    @Bean
    @Order(2)
    public AccountRealm accountRealm( HashedCredentialsMatcher hashedCredentialsMatcher,CacheManager cacheManager) {
        AccountRealm accountRealm = new AccountRealm();
        accountRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        accountRealm.setCacheManager(cacheManager);
        return accountRealm;
    }

    @Bean
    @Order(0)
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }


    //==============================Redis 配置==================================
    @Bean
    @Order(0)
    public RedisManager redisManager(RedisProperties redisProperties){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost("127.0.0.1:6379");
        redisManager.setPassword(redisProperties.getPassword());
//        redisManager.setJedisPoolConfig();
        if(redisProperties.getTimeout()!=null){
            redisManager.setTimeout((int)redisProperties.getTimeout().getSeconds());
        }
        return redisManager;
    }

    //==============================Cache Manager 配置==================================
    @Bean
    @Order(1)
    public CacheManager cacheManager(RedisManager redisManager) {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        ShiroFastJsonRedisSerializer shiroFastJsonRedisSerializer = new ShiroFastJsonRedisSerializer();
        redisCacheManager.setRedisManager(redisManager);
        redisCacheManager.setKeyPrefix("shiro-");
        redisCacheManager.setValueSerializer(shiroFastJsonRedisSerializer);
        redisCacheManager.setKeySerializer(new StringSerializer());
        return redisCacheManager;
    }
    //==============================Session Cookie Id 配置==================================
    @Bean
    @Order(0)
    public SimpleCookie simpleCookie(){
        //初始化cookie
        SimpleCookie simpleCookie = new SimpleCookie("sid");
        /**
         *  setcookie的httponly属性设为true的话,会增加对xss防护的安全系数.它有以下特点:
         *  1.设为true后,只允许http(s)访问,不能通过JavaScript访问
         *  2.防止xss读取cookie
         */
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");
        // -1表示永久生效
        simpleCookie.setMaxAge(-1);
        return simpleCookie;
    }
    //==============================Session Dao 配置==================================
    @Bean
    @Order(1)
    public SessionDAO sessionDAO(RedisManager redisManager) {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager);
        //session在redis中的保存时间,最好大于session会话超时时间
//        redisManager.setExpire(12000);
        return redisSessionDAO;
    }

    //==============================Session Listener 配置==================================
//    @Bean
//    public ShiroSessionListener  sessionListener(){
//
//    }

    //==============================Session Manager 配置==================================
    @Bean
    @Order(3)
    public SessionManager sessionManager(SimpleCookie simpleCookie,
                                         SessionDAO sessionDAO,
                                         CacheManager cacheManager){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        sessionManager.setSessionIdCookie(simpleCookie);
        sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setCacheManager(cacheManager);

        // 全局session会话超时时间,默认半小时
        sessionManager.setGlobalSessionTimeout(1800000);
        // 自动删除无需会话,默认为true
        sessionManager.setDeleteInvalidSessions(true);
        // 开启定时调度器检测过期会话,默认为true
        sessionManager.setSessionValidationSchedulerEnabled(true);
        /**
         * 设置session失效的扫描时间间隔,清理用户直接关闭浏览器造成的孤立会话,默认1小时
         * 设置该属性时,就不需要设置setSessionValidationSchedulerEnabled,其底层也是某人调用ExecutorServiceSessionValidationScheduler
         * TODO: 暂时设定为10s
         */
        sessionManager.setSessionValidationInterval(1800000);
        //取消url 后面的 JSESSIONID
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }
}
