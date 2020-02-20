package club.mikusun.iadmin.account.service;

import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.domain.account.Permission;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroTokenService;
import club.mikusun.iadmin.top.account.service.TopPermissionService;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionService  extends TopPermissionService {
}
