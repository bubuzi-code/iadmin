package club.mikusun.iadmin.account.controller;

import club.mikusun.iadmin.account.dao.AccountDao;
import club.mikusun.iadmin.account.dao.PermissionDao;
import club.mikusun.iadmin.account.dao.RoleDao;
import club.mikusun.iadmin.account.shiro.token.CustomToken;
import club.mikusun.iadmin.cache.server.RedisServer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RedisServer redisServer;

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @PostMapping("")
    public Object login(@RequestBody CustomToken customToken ,
                        HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        subject.login(customToken);
//        Cookie cookie = new Cookie("")
        redisServer.set("cookie",customToken.getPrincipal());
        redisServer.set("account",subject.getPrincipal());
        return "ok";
    }

    @GetMapping("")
    public Object logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "ok";
    }

    @PostMapping("/{index}")
    public Object t1(@PathVariable("index") int index){
        return roleDao.getOne(index);
    }

    @PostMapping("/t2")
    public Object t2(){
        return permissionDao.getOne(1);
    }
}
