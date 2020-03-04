package club.mikusun.iadmin.account.service;

import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccountService;
import club.mikusun.iadmin.spring.shiro.token.AccountToken;

public interface LoginService extends ShiroAccountService<Account> {
    Account_Token saveToken(Account account);
    Account login(AccountToken accountToken) throws Exception;
}
