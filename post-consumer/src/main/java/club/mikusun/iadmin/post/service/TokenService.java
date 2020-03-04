package club.mikusun.iadmin.post.service;

import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroTokenService;

public interface TokenService extends ShiroTokenService<Account_Token> {
}
