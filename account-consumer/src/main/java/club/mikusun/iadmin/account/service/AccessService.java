package club.mikusun.iadmin.account.service;

import club.mikusun.iadmin.domain.account.Account_access;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccessService;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessService
        extends BaseService<Account_access, Integer>, ShiroAccessService<Account_access> {
}
