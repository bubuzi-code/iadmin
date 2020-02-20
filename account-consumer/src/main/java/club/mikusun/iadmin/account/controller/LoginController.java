package club.mikusun.iadmin.account.controller;

import club.mikusun.iadmin.account.service.PermissionService;
import club.mikusun.iadmin.account.service.RoleService;
import club.mikusun.iadmin.account.service.TokenService;
import club.mikusun.iadmin.cache.server.RedisServer;
import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.spring.shiro.token.AccountToken;
import club.mikusun.iadmin.webutils.result.account.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RedisServer redisServer;

//    @Autowired
//    private AccountDao accountDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private ApplicationContext ioc;
    @Autowired
    private ShiroFilterFactoryBean shiroFilterFactoryBean;

    @PostMapping("")
    public Object login(@RequestBody AccountToken accountToken ,
                        HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        subject.login(accountToken);
        Account account = (Account) subject.getPrincipal();
        Account_Token token = tokenService.createToken((Account) subject.getPrincipal());
        Cookie cookie = new Cookie("token",token.getToken());
        response.addCookie(cookie);
        String redisKey = token.getRedisKey();
        redisServer.set(token.getToken() , token);
        redisServer.expire(token.getToken() , token.getRedisExpireTime());
        redisServer.set(redisKey , account);
        redisServer.expire(redisKey , token.getRedisExpireTime());
        return Result.success();
    }

    @GetMapping("")
    public Object logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "ok";
    }

    @PostMapping("/{index}")
    public Object t1(@PathVariable("index") int index){

        return "";
    }

    @PostMapping("/t2")
    public Object t2(){
        return permissionService.getOne(1);
    }

    @PostMapping("/t3")
    public Object t3(){
        System.err.println(shiroFilterFactoryBean);
//        Map<String, QueryByExampleExecutor> beansOfType = ioc.getBeansOfType(QueryByExampleExecutor.class);
//        beansOfType.forEach((k , v)->{
//            System.err.printf("key: %s ,\t value: %s\n" , k , v.getClass().toString());
//        });
        return "ok";
    }

}
