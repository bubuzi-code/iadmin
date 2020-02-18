package club.mikusun.iadmin.account.service.impl;

import club.mikusun.iadmin.account.dao.TokenDao;
import club.mikusun.iadmin.account.service.AccountService;
import club.mikusun.iadmin.account.service.TokenService;
import club.mikusun.iadmin.cache.server.RedisServer;
import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.toolutils.R;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
public class TokenServiceImpl extends BaseServiceImpl<Account_Token , String>
        implements TokenService{
    @Getter
    private TokenDao dao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RedisServer redisServer;

    public TokenServiceImpl(TokenDao dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public Account_Token findAccountByToken(String token) {
        return getDao().findOneByToken(token);
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

    /**
     * 创建token
     * @param account
     * @return
     */
    @Override
    @Transactional
    public Account_Token createToken(Account account) {
        if(null == account){
            throw new IllegalArgumentException("非法参数");
        }

        String token = R.randomString(64);
        Account_Token accountToken = this.findOneByUid(account.getUid());
        if(null == accountToken){
            accountToken = new Account_Token()
                    .setToken(token)
                    .setUid(account.getUid())
                    .setCreateTime(System.currentTimeMillis()/1000)
                    .setLastUpdateTime(System.currentTimeMillis()/1000)
                    .setExpireTime(System.currentTimeMillis()/1000+60*60*24*7);
        }else{
            accountToken.setToken(token)
                    .setLastUpdateTime(System.currentTimeMillis()/1000)
                    .setExpireTime(System.currentTimeMillis()/1000+60*60*24*7);
        }

        return save(accountToken);
    }

    @Override
    public Account_Token findOneByUid(int uid) {
        return this.getDao().findOneByUid(uid);
    }


}
