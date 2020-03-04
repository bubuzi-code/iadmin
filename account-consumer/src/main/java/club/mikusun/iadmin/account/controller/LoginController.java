package club.mikusun.iadmin.account.controller;

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

    @Autowired
    private TokenService tokenService;


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

}
