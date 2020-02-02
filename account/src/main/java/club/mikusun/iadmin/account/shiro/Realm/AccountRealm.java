package club.mikusun.iadmin.account.shiro.Realm;

import club.mikusun.iadmin.account.shiro.token.CustomToken;
import club.mikusun.iadmin.domain.account.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountRealm extends AuthorizingRealm {

    @Override
    // 获得账户权限详情
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Account account = (club.mikusun.iadmin.domain.account.Account) SecurityUtils.getSubject().getPrincipal();
        String account_str = account.getAccount_str();
        // 构建简单账户详情
        // todo: 这里将通过权限表动态注入权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> permissions = new HashSet<>();
        permissions.add("account.login");
        permissions.add("account.out");
        info.addStringPermissions(permissions);
        return info;
    }

    @Override
    // 身份认证方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account_str = (String) authenticationToken.getPrincipal();
        String password = (String) authenticationToken.getCredentials();
        if (account_str == null) {
            throw new AccountException("用户名不正确");
        } else if (!"123456".equals(password)) {
            throw new AccountException("密码不正确");
        }

        return new SimpleAuthenticationInfo(account_str,password,getName());
    }
}
