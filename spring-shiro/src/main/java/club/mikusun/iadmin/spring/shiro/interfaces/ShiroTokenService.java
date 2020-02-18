package club.mikusun.iadmin.spring.shiro.interfaces;


import club.mikusun.iadmin.domain.module.interfaces.I_Token;

public interface ShiroTokenService<T extends I_Token> {

    T shiroFindAccountByToken(String token);

    long getExpireTime(String token);
    boolean isExpired(String token);
}
