package club.mikusun.iadmin.spring.shiro.interfaces;


import club.mikusun.iadmin.domain.account.Account_Token;

public interface ShiroTokenService {

    Account_Token findAccountByToken(String token);

    long getExpireTime(String token);
    boolean isExpired(String token);
}
