package club.mikusun.iadmin.account.service.impl;


import club.mikusun.iadmin.account.feign.TokenFeginClient;
import club.mikusun.iadmin.account.service.TokenService;
import club.mikusun.iadmin.cache.server.RedisServer;
import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.toolutils.R;
import club.mikusun.iadmin.webutils.result.account.Result;
import org.apache.shiro.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService{


    @Autowired
    private RedisServer redisServer;

    @Autowired
    private TokenFeginClient tokenFeginClient;

    @Override
    public Account_Token shiroFindAccountByToken(String token) {
        Result result = tokenFeginClient.one(token);
        return result.isSuccess()?(Account_Token)result.getData():null;
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

    @Override
    public Account_Token createToken(Account account) {
        Assert.notNull(account,"非法参数");
        String token = R.randomString(64);
        Account_Token accountToken = this.findOneByUid(account.getUid());
        if(null == accountToken){
            accountToken = new Account_Token()
                    .setToken(token)
                    .setUid(account.getUid())
                    .setCreateTime(System.currentTimeMillis()/1000)
                    .setLastUpdateTime(System.currentTimeMillis()/1000)
                    .setExpireTime(System.currentTimeMillis()/1000+60*60*24*7);
            accountToken = tokenFeginClient.save(accountToken).ifPresentAndConvertObj(accountToken.getClass());
            redisServer.set(accountToken.getRedisKey() , accountToken ,1000+60*60*24*7);
        }else{
            accountToken.setToken(token)
                    .setLastUpdateTime(System.currentTimeMillis()/1000)
                    .setExpireTime(System.currentTimeMillis()/1000+60*60*24*7);
            tokenFeginClient.save(accountToken);
            redisServer.set(accountToken.getRedisKey() , accountToken ,1000+60*60*24*7);
        }
        return accountToken;
    }

    @Override
    public Account_Token findOneByUid(int uid) {
        Result result = this.tokenFeginClient.one(uid);
        return result.ifPresentAndConvertObj(Account_Token.class , true);
    }


}
