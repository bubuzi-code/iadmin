package club.mikusun.iadmin.post.controller;

import club.mikusun.iadmin.webutils.result.account.Result;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    @PostMapping("/upvote")
    @RequiresPermissions("UPVOTE")
    public Object upvote(){
        return Result.success();
    }

    @PostMapping("/delete")
    @RequiresPermissions("DELETE")
    public Object delete(){
        return Result.success();
    }
}
