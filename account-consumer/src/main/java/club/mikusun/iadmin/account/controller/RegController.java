package club.mikusun.iadmin.account.controller;

import club.mikusun.iadmin.account.service.AccountService;
import club.mikusun.iadmin.account.util.StringUtil;
import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.spring.shiro.token.AccountToken;
import club.mikusun.iadmin.toolutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegController {
    @Autowired
    private AccountService accountService;

    @PostMapping("")
    public Object reg(@RequestBody AccountToken accountToken){
        String account_str = (String) accountToken.getPrincipal();
        String password = (String) accountToken.getCredentials();
        String salt = R.randomString(16);
        Account account = new Account(account_str, StringUtil.md5(password,salt),salt);
        Account save = accountService.save(account);
        return save;
    }
}
