package club.mikusun.iadmin.provide.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("club.mikusun.iadmin.domain.account")
@EnableJpaRepositories(basePackages = {"club.mikusun.iadmin.provide.account.dao"})
@EnableEurekaClient
public class AccountProvideApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountProvideApplication.class , args);
    }
}
