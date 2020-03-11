package club.mikusun.iadmin.provide.post.controller;

import club.mikusun.iadmin.db.data.Direction;
import club.mikusun.iadmin.db.data.PageDto;
import club.mikusun.iadmin.domain.post.Post;
import club.mikusun.iadmin.provide.post.service.PostService;
import club.mikusun.iadmin.webutils.asserts.HttpAssert;
import club.mikusun.iadmin.webutils.result.account.HttpResult;
import club.mikusun.iadmin.webutils.result.account.Result;
import com.alibaba.fastjson.JSON;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.data.domain.*;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/all")
    public Object all(
            @RequestParam("isHot") Boolean isHot ,
            @RequestParam("pageDto")PageDto pageDto) throws Exception {
        HttpAssert.nonNullBad(pageDto , "pageDto is null");
        Pageable page = pageDto.toPageable();
        return Result.success(postService.findAll(page));
    }
    @PostMapping("/one/{id}")
    public Object one(@PathVariable Integer id){
        return postService.getOne(id);
    }

}
