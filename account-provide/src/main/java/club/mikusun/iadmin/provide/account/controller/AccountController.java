package club.mikusun.iadmin.provide.account.controller;

import club.mikusun.iadmin.top.account.service.TopAccountService;
import club.mikusun.iadmin.webutils.result.account.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private TopAccountService topAccountService;

    @PostMapping("/{id}")
    public Object getOne(@PathVariable("id") Integer id){
        return Result.success(topAccountService.getOne(id));
    }
}
