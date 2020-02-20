package club.mikusun.iadmin.account.service;

import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroTokenService;
import club.mikusun.iadmin.top.account.service.TopTokenService;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenService
        extends TopTokenService, ShiroTokenService<Account_Token> {

    Account_Token createToken(Account account);
    Account_Token findOneByUid(int uid);
}
