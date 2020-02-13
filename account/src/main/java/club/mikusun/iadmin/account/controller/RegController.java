package club.mikusun.iadmin.account.controller;

import club.mikusun.iadmin.account.dao.AccountDao;
import club.mikusun.iadmin.account.shiro.token.CustomToken;
import club.mikusun.iadmin.account.util.R;
import club.mikusun.iadmin.account.util.StringUtil;
import club.mikusun.iadmin.domain.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reg")
public class RegController {
    @Autowired
    private AccountDao accountDao;

    @PostMapping("")
    public Object reg(@RequestBody CustomToken customToken){
        String account_str = (String) customToken.getPrincipal();
        String password = (String) customToken.getCredentials();
        String salt = R.randomString(16);
        Account account = new Account(account_str, StringUtil.md5(password,salt),salt);
        Account save = accountDao.save(account);
        return save;
    }
}
