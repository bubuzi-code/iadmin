package club.mikusun.iadmin.domain.account;

import lombok.Data;

@Data
public class Account {
    // 账户id
    private String id;
    // 用户id
    private String uid;
    // 账户号
    private String account_str;
    // 账户密码
    private String password;
    // 账户掩码
    private String salt;
}
