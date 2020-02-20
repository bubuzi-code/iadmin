package club.mikusun.iadmin.account.service;

import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccessService;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccountService;
import club.mikusun.iadmin.top.account.service.TopAccountService;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountService extends TopAccountService, ShiroAccountService<Account> {
}
