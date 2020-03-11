package club.mikusun.iadmin.provide.account.service.impl;


import club.mikusun.iadmin.db.depencies.jpa.service.impl.BaseServiceImpl;
import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.provide.account.dao.AccountDao;
import club.mikusun.iadmin.provide.account.service.AccountService;
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
    public Account findAccountByAccountStr(String accountStr) {
        return this.getDao().findAccountByAccount(accountStr);
    }
}
