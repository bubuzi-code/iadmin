package club.mikusun.iadmin.provide.account.service;

import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.domain.account.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountService extends BaseService<Account, Integer> {
    Account findAccountByAccountStr(String account_str);
}
