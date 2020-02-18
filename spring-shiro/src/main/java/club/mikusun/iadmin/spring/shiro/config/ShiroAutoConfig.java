package club.mikusun.iadmin.spring.shiro.config;

import club.mikusun.iadmin.spring.shiro.advice.ShiroExceptionAdive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroAutoConfig {
    @Bean
    public ShiroExceptionAdive shiroExceptionAdive(){
        System.err.println("shiroExceptionAdive创建了");
        return new ShiroExceptionAdive();
    }
}
