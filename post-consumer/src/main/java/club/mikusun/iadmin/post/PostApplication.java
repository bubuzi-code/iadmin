package club.mikusun.iadmin.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"club.mikusun.iadmin.post.dao"})
@EntityScan("club.mikusun.iadmin.domain.post")
public class PostApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostApplication.class ,args);
    }

}
