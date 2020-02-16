package club.mikusun.iadmin.account.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class HomeController {

    @RequiresPermissions("accounasdasdwasdt1")
    @GetMapping("/index")
    public Object index(){
        System.err.println("asdwdasdwadsd");
        return "1233212131";
    }

}
