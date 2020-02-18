package club.mikusun.iadmin.spring.shiro.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.Serializable;


@ConfigurationProperties(prefix = "mikusun.shiro")
@Data
public class ShiroProperties implements Serializable {
    // authc | oauth2
    private AUTH_METHOD auth_method = AUTH_METHOD.AUTHC;

    public enum AUTH_METHOD{
        // 传统的用户名密码验证
        AUTHC("authc"),
        // TOKEN验证
        OAUTH2("oauth2");
        @Getter
        private String name;
        AUTH_METHOD(String name){
            this.name = name;
        }
    }
}
