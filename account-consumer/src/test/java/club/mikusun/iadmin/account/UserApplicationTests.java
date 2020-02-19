package club.mikusun.iadmin.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest(classes = AccountApplication.class)
class UserApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws Exception{
        Connection connection = dataSource.getConnection();

    }

}
