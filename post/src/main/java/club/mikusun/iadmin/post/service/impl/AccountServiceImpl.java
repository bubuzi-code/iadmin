package club.mikusun.iadmin.post.service.impl;

import club.mikusun.iadmin.cache.server.RedisServer;
import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.post.dao.AccessDao;
import club.mikusun.iadmin.post.service.AccessService;
import club.mikusun.iadmin.post.service.AccountService;
import com.alibaba.fastjson.JSON;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account, Integer> implements AccountService {

    @Autowired
    private RedisServer redisServer;
    //    @Getter
//    private Acc dao;
    public AccountServiceImpl() {
        super(null);
    }

    @Override
    public Account shiroFindAccountByRedisKey(String redisKey) {
        String json = redisServer.get(redisKey).toString();
        Account account = JSON.parseObject(json, Account.class);
        return account;
    }
}
