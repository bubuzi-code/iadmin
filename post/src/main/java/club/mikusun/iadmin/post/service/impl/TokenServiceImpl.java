package club.mikusun.iadmin.post.service.impl;

import club.mikusun.iadmin.cache.server.RedisServer;
import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.post.dao.AccessDao;
import club.mikusun.iadmin.post.service.AccessService;
import club.mikusun.iadmin.post.service.TokenService;
import club.mikusun.iadmin.spring.shiro.token.AccountToken;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl extends BaseServiceImpl<Account_Token, Integer> implements TokenService {

    @Autowired
    private RedisServer redisServer;

    //    @Getter
//    private AccessDao dao;
    public TokenServiceImpl() {
        super(null);
//        super(dao);
//        this.dao = dao;
    }

    @Override
    public Account_Token shiroFindAccountByToken(String token) {
        String json = redisServer.get(token).toString();
        Account_Token accountToken = JSON.parseObject(json, Account_Token.class);
        return accountToken;
    }

    @Override
    public long getExpireTime(String token) {
        return redisServer.getExpire(token);
    }

    @Override
    public boolean isExpired(String token) {
        return getExpireTime(token)==-2;
    }
}
