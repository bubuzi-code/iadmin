package club.mikusun.iadmin.account.controller;

import club.mikusun.iadmin.account.dao.AccountDao;
import club.mikusun.iadmin.account.shiro.token.CustomToken;
import club.mikusun.iadmin.account.util.R;
import club.mikusun.iadmin.cache.server.RedisServer;
import club.mikusun.iadmin.domain.account.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RedisServer redisServer;

    @Autowired
    private AccountDao accountDao;

    @PostMapping("")
    public Object login(@RequestBody CustomToken customToken , HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        subject.login(customToken);
//        Cookie cookie = new Cookie("")
        redisServer.set("cookie",customToken.getPrincipal());
        redisServer.set("account",subject.getPrincipal());
        return "ok";
    }

}
