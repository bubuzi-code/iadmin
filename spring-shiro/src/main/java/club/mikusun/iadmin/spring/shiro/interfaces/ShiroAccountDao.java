package club.mikusun.iadmin.spring.shiro.interfaces;

import club.mikusun.iadmin.domain.account.Account;

public interface ShiroAccountDao {
    Account findAccountByAccount(String account_str);
}
