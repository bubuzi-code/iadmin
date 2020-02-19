package club.mikusun.iadmin.account.service;

import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccessService;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccountService;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountService extends BaseService<Account, Integer>, ShiroAccountService {
}
