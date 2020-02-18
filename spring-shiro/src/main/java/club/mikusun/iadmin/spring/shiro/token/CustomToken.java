package club.mikusun.iadmin.spring.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

public class CustomToken extends UsernamePasswordToken {
    private String account;
    private String password;
    private String host;

    public CustomToken(String account, String password) {
        this.account = account;
        this.password = password;
    }

    @Override
    public Object getPrincipal() {
        return this.account;
    }

    @Override
    public Object getCredentials() {
        return this.password;
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public boolean isRememberMe() {
        return false;
    }
}
