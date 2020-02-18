package club.mikusun.iadmin.domain.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;

@Entity
@Table(name = "account_token" , indexes = {
        @Index(name = "TOKEN_MAPPING" , columnList = "token,uid")
})
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Account_Token {

    @Id
    @Column
    private int uid;


    @Column
    private String token;

    // 创建时间(s)
    @Column
    private long createTime;

    // 最后更新时间
    @Column
    private long lastUpdateTime;

    // 过期时间(s)
    @Column
    private long expireTime;

    public long getRedisExpireTime(){
        long now = System.currentTimeMillis()/1000 - expireTime;
        return now>0?now:0;
    };
}
