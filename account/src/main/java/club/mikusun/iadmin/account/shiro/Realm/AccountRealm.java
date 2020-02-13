package club.mikusun.iadmin.account.shiro.Realm;

import club.mikusun.iadmin.account.dao.AccountDao;
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
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private AccountDao accountDao;

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
        // 当前登录用户的用户名
        String account_str = (String) authenticationToken.getPrincipal();
        // 获取数据库中对应的用户数据
        Account account = accountDao.findAccountByAccount(account_str);
        // 通过掩码计算出盐
        ByteSource salt = ByteSource.Util.bytes(account.getSalt());

        return new SimpleAuthenticationInfo(account,account.getPassword(),salt,getName());
    }
}
