package club.mikusun.iadmin.provide.account.controller;

import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.provide.account.service.TokenService;
import club.mikusun.iadmin.webutils.result.account.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/one/id/{id}")
    public Object one(@PathVariable("id")Integer id){
        Assert.notNull(id , "id is null");
        return Result.success(tokenService.getOne(id));
    }

    @PostMapping("/one/token/{token}")
    public Object one(@PathVariable("token")String token){
        Assert.notNull(token, "token is null");
        return Result.success(tokenService.findOneByToken(token));
    }

    @PostMapping("/save/one")
    public Object save(@RequestBody Account_Token data){
        Assert.notNull(data,"data is null");
        Account_Token result = null;
        String error = null;
        try {
            result = tokenService.save((Account_Token) data);
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
            result = tokenService.saveAll(data);
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
            result = tokenService.saveAndFlush((Account_Token) data);
        } catch (Exception e) {
            e.printStackTrace();
            error = e.getMessage();
        }
        return (null == result && null == error )
                ? Result.success(result):Result.error(error);
    }


}
