package club.mikusun.iadmin.account.controller;

import club.mikusun.iadmin.account.shiro.token.CustomToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping("")
    public Object login(@RequestParam("account")String account,
                        @RequestParam("password")String password){

        Subject subject = SecurityUtils.getSubject();
        subject.login(new CustomToken(account,password));
        redisTemplate.opsForValue().set("cookie",account);
        return "";
    }
}
