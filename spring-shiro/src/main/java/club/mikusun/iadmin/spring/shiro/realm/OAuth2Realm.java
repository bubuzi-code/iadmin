package club.mikusun.iadmin.spring.shiro.realm;

import club.mikusun.iadmin.domain.account.Account;
import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.domain.account.Role;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroAccountService;
import club.mikusun.iadmin.spring.shiro.interfaces.ShiroTokenService;
import club.mikusun.iadmin.spring.shiro.token.OAuth2Token;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 用于单点登陆时token授权
 */
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private ShiroAccountService shiroAccountService;

    @Autowired
    private ShiroTokenService shiroTokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(接口保护，验证接口调用权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        Account account = (Account)principals.getPrimaryPrincipal();
        Set<String> permissions = new HashSet<>();

        Set<Role> roles = account.getRoles();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        roles.forEach(v->{
            info.addRole(v.getName());
            v.getPermissions().forEach(j -> {
                permissions.add(j.getPermission());
            });
        });

        info.addStringPermissions(permissions);
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        if(StringUtils.hasText(token)){
            // 根据token拿到用户数据,忽略具体实现
            Account_Token accountToken = shiroTokenService.findAccountByToken(token);
            // 判断token是否合法 或 是否过期
            if(null == accountToken || shiroTokenService.isExpired(token)){
                throw new IncorrectCredentialsException("token失效，请重新登录");
            }
            Account account = shiroAccountService.findAccountByUid(accountToken.getUid());
            return new SimpleAuthenticationInfo(account,token,getName());
        }
        return null;
    }
}
