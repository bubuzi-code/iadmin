package club.mikusun.iadmin.spring.shiro.interfaces;



import club.mikusun.iadmin.domain.module.interfaces.I_Account;

public interface ShiroAccountService<T extends I_Account> {
    T shiroFindAccountByAccountStr(String account_str);
    T shiroFindAccountByUid(int uid);
}
