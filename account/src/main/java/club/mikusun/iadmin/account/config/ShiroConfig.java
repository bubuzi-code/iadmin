package club.mikusun.iadmin.account.config;

import club.mikusun.iadmin.account.shiro.Realm.AccountRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // 传入shiro安全管理器
    @Bean
    @Order(3)
    public  ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        // Shiro过滤器创建工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 绑定安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 指定登录链接
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 指定没有权限时跳转的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/..");
        // 权限认证链接map
        // TODO: 之后通过数据库动态导入
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/front/**", "anon");
        filterChainDefinitionMap.put("/api/**", "anon");

        filterChainDefinitionMap.put("/admin/**", "authc");
        filterChainDefinitionMap.put("/user/**", "authc");

        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    @Order(2)
    public SecurityManager securityManager(AccountRealm accountRealm) {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(accountRealm);
        return defaultSecurityManager;
    }

    @Bean
    @Order(1)
    public AccountRealm customRealm() {
        AccountRealm customRealm = new AccountRealm();
        return customRealm;
    }
}
