package club.mikusun.iadmin.spring.shiro.token;

import lombok.NoArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

import java.io.Serializable;

@NoArgsConstructor
public class OAuth2Token implements AuthenticationToken, Serializable {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return  this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
