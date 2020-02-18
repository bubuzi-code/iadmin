package club.mikusun.iadmin.post.service;

import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccessService;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccountService;

public interface AccountService extends BaseService<Account, Integer> , ShiroAccountService<Account> {
}
