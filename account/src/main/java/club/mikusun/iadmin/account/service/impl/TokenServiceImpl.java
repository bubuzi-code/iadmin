package club.mikusun.iadmin.account.service.impl;

import club.mikusun.iadmin.account.dao.TokenDao;
import club.mikusun.iadmin.account.service.TokenService;
import club.mikusun.iadmin.cache.server.RedisServer;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroTokenService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl extends BaseServiceImpl<Account_Token , String>
        implements TokenService{
    @Getter
    private TokenDao dao;

    @Autowired
    private RedisServer redisServer;

    public TokenServiceImpl(TokenDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public Account_Token findAccountByToken(String token) {
        return getDao().findAccountByToken(token);
    }

    @Override
    public long getExpireTime(String token) {
        return redisServer.getExpire(token);
    }

    @Override
    public boolean isExpired(String token) {
        long expireTime = this.getExpireTime(token);
        return expireTime==-2;
    }

}
