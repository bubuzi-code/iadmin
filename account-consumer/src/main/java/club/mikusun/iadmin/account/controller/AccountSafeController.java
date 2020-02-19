package club.mikusun.iadmin.account.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountSafeController {

    @PostMapping("/upvote")
    @RequiresPermissions("UPVOTE")
    public Object upvote(){
        return "UPVOTE";
    }

    @PostMapping("/delete")
    @RequiresPermissions("DELETE")
    public Object delete(){
        return "DELETE";
    }
}
