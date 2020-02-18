package club.mikusun.iadmin.spring.shiro.interfaces;

import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Account_Token;

public interface ShiroAccountService {
    Account findAccountByAccount(String account_str);
    Account findAccountByUid(int uid);
}
