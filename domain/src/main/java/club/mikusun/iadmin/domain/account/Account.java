package club.mikusun.iadmin.domain.account;

import club.mikusun.iadmin.domain.module.interfaces.I_Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.ConstraintMode.*;

@Data
@Entity
@Table(name="account",indexes = {
        @Index(name = "account",columnList = "account_str" , unique = true),
        @Index(name = "uid" , columnList = "uid" , unique = true)
})
@NoArgsConstructor
public class Account implements Serializable, I_Account {
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

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.REFRESH}
    )
    @Fetch(FetchMode.SELECT)
    @JoinTable(
            name = "account_role",
            joinColumns = {@JoinColumn(
                            name = "uid",
                            referencedColumnName = "uid" ,
                            foreignKey = @ForeignKey(name = "test1",value = NO_CONSTRAINT)
                    )},
            inverseJoinColumns = {@JoinColumn(
                    name = "rid" ,
                    foreignKey = @ForeignKey(name = "test1",value = NO_CONSTRAINT)
            )},
            foreignKey = @ForeignKey(value = NO_CONSTRAINT),
            inverseForeignKey = @ForeignKey(value = NO_CONSTRAINT)
    )
    private Set<Role> roles;

    public Account(String accounr,String password,String salt){
        this.account_str = accounr;
        this.password = password;
        this.salt = salt;
    }

    public int getId(){
        return this.uid;
    }
}
