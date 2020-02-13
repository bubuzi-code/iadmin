package club.mikusun.iadmin.domain.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="account",indexes = {
        @Index(name = "account",columnList = "account_str" , unique = true),
        @Index(name = "uid" , columnList = "uid" , unique = true)
})
@NoArgsConstructor
public class Account implements Serializable {
    // 账户id
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
//    private String id;

    // 用户id
    @Id
    @Column
    private int uid;

    // 账户号
    @Column
    private String account_str;

    // 账户密码
    @Column
    private String password;

    // 账户掩码
    @Column
    private String salt;

    public Account(String accounr,String password,String salt){
        this.account_str = accounr;
        this.password = password;
        this.salt = salt;
    }
}
