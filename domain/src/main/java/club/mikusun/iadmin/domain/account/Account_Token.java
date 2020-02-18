package club.mikusun.iadmin.domain.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;

@Entity
@Table(name = "account_token" , indexes = {
        @Index(name = "TOKEN_MAPPING" , columnList = "uid,token")
})
@NoArgsConstructor
@Data
public class Account_Token {

    @Column
    private int uid;

    @Id
    @Column
    private String token;
}
