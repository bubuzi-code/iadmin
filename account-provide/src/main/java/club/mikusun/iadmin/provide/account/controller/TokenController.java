package club.mikusun.iadmin.provide.account.controller;

import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.top.account.service.TopTokenService;
import club.mikusun.iadmin.webutils.result.account.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TopTokenService topTokenService;

    @PostMapping("/one/id/{id}")
    public Object one(@PathVariable("id")Integer id){
        Assert.notNull(id , "id is null");
        return Result.success(topTokenService.getOne(id));
    }

    @PostMapping("/one/token/{token}")
    public Object one(@PathVariable("token")String token){
        Assert.notNull(token, "token is null");
        return Result.success(topTokenService.findOneByToken(token));
    }

    @PostMapping("/save/one")
    public Object save(@RequestBody Account_Token data){
        Assert.notNull(data,"data is null");
        Account_Token result = null;
        String error = null;
        try {
            result = topTokenService.save((Account_Token) data);
        } catch (Exception e) {
            e.printStackTrace();
            error = e.getMessage();
        }
        return ( null == result  && null == error )
                ? Result.success(result):Result.error(error);
    }

    @PostMapping("/save/list")
    public Object save(@RequestBody Iterable<Account_Token> data){
        Assert.notNull(data,"data is null");
        List<Account_Token> result = null;
        String error = null;
        try {
            result = topTokenService.saveAll(data);
        } catch (Exception e) {
            e.printStackTrace();
            error = e.getMessage();
        }
        return ( null == result  && null == error )
                ? Result.success(result):Result.error(error);
    }

    @PostMapping("/update/one")
    public Object update(@RequestBody Account_Token data){
        Assert.notNull(data,"data is null");
        Account_Token result = null;
        String error = null;
        try {
            result = topTokenService.saveAndFlush((Account_Token) data);
        } catch (Exception e) {
            e.printStackTrace();
            error = e.getMessage();
        }
        return (null == result && null == error )
                ? Result.success(result):Result.error(error);
    }


}
