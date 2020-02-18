package club.mikusun.iadmin.account.service.impl;

import club.mikusun.iadmin.account.dao.AccountDao;
import club.mikusun.iadmin.account.service.AccountService;
import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccountService;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account , Integer>
        implements AccountService {
    @Getter
    private AccountDao dao;

    public AccountServiceImpl(AccountDao dao) {
        super(dao);
        this.dao = dao;
    }


    @Override
    public Account findAccountByAccount(String account_str) {
        return this.getDao().findAccountByAccount(account_str);
    }

    @Override
    public Account findAccountByUid(int uid) {
        return this.getDao().findAccountByUid(uid);
    }
}
