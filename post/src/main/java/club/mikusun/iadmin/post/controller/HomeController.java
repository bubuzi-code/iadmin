package club.mikusun.iadmin.post.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("")
    public Object user(){
        Object principal = SecurityUtils.getSubject().getPrincipal();
        System.err.println(principal);
        return principal;
    }
}
