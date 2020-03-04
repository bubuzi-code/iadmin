package club.mikusun.iadmin.account.service.impl;


import club.mikusun.iadmin.account.feign.AccountFeignClient;
import club.mikusun.iadmin.account.service.AccountService;
import club.mikusun.iadmin.domain.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    public AccountFeignClient accountFeignClient;


    @Override
    public Account shiroFindAccountByAccountStr(String account_str) {
        Account account = accountFeignClient.one(account_str).ifPresentAndConvertObj(Account.class, true);
        return account;
    }

    @Override
    public Account shiroFindAccountByRedisKey(String redisKey) {
        return null;
    }


    @Override
    public Account save(Account account) {
        return null;
    }
}
