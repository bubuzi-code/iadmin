package club.mikusun.iadmin.provide.account.service;


import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.domain.account.Account_Token;

import org.springframework.stereotype.Repository;


@Repository
public interface TokenService extends BaseService<Account_Token , Integer> {
    Account_Token findOneByToken(String token);
}
