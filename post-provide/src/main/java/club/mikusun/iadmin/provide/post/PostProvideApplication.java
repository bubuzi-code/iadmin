package club.mikusun.iadmin.provide.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("club.mikusun.iadmin.domain.post")
@EnableJpaRepositories(basePackages = {"club.mikusun.iadmin.provide.post.dao"})
@EnableEurekaClient
public class PostProvideApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostProvideApplication.class , args);
    }
}
