package club.mikusun.iadmin.domain.account;

import club.mikusun.iadmin.domain.module.interfaces.I_Token;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Base64;

@Entity
@Table(name = "account_token" , indexes = {
        @Index(name = "TOKEN_MAPPING" , columnList = "token,uid")
})
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Account_Token implements Serializable, I_Token {

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

    @Override
    public String getRedisKey() {
        Base64.Encoder encoder = Base64.getEncoder();
        StringBuffer buffer = new StringBuffer(getClass().getName()+":"+this.uid);
        byte[] encode = encoder.encode(buffer.toString().getBytes());

        return new String(encode);
    }

}
