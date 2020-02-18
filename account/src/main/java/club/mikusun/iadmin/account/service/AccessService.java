package club.mikusun.iadmin.account.service;

import club.mikusun.iadmin.domain.account.Access;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccessService;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroTokenService;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessService extends BaseService<Access, Integer>, ShiroAccessService {
}
