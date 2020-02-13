package club.mikusun.iadmin.account.util;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class AccountResult implements Serializable {
    private int code;
    private String massage;
    private Object data;

    private AccountResult(){}
    private AccountResult(int code,String massage){
        this(code,massage,null);
    }
    private AccountResult(int code,String massage,Object data){
        this.code = code;
        this.massage = massage;
        this.data = data;
    }
    public static AccountResult badRequest(){
        return new AccountResult(400,"bad request [Illegal Argument Exception]");
    }
}
