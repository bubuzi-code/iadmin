package club.mikusun.iadmin.spring.shiro.realm;


import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Role;
import club.mikusun.iadmin.domain.module.interfaces.I_Account;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private ShiroAccountService shiroAccountService;

    @Override
    // 获得账户权限详情
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Account account = (Account) SecurityUtils.getSubject().getPrincipal();
        /**
         * 这里已经通过密码验证,将其重要字段置空,防止数据泄露
         */
        account.ignoreMajor();
        // 构建简单账户详情
        // todo: 这里将通过权限表动态注入权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> permissions = new HashSet<>();

        Set<Role> roles = account.getRoles();

        roles.forEach(v->{
            info.addRole(v.getName());
            v.getPermissions().forEach(j -> {
                permissions.add(j.getPermission());
            });
        });

        info.addStringPermissions(permissions);

        return info;
    }

    @Override
    // 身份认证方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 当前登录用户的用户名
        String account_str = (String) authenticationToken.getPrincipal();
        // 获取数据库中对应的用户数据
        I_Account account = shiroAccountService.shiroFindAccountByAccountStr(account_str);
        if(null == account){
            // 账户不存在 抛出异常 忽略异常处理
            throw new UnknownAccountException();
        }
        // 通过掩码计算出盐
        ByteSource salt = ByteSource.Util.bytes(account.getSalt());

        return new SimpleAuthenticationInfo(account,account.getPassword(),salt,getName());
    }
}

