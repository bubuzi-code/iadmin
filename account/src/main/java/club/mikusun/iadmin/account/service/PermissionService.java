package club.mikusun.iadmin.account.service;

import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.domain.account.Permission;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroTokenService;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionService  extends BaseService<Permission, Integer>{
}
