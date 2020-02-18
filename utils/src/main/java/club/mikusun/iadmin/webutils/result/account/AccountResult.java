package club.mikusun.iadmin.webutils.result.account;

import club.mikusun.iadmin.webutils.result.BaseResult;

public class AccountResult extends BaseResult {
    protected AccountResult(int code) {
        super(code);
    }

    protected AccountResult(int code, String massage) {
        super(code, massage);
    }

    protected AccountResult(int code, String massage, Object data) {
        super(code, massage, data);
    }

    public static AccountResult badRequest(){
        return new AccountResult(400,"bad request [Illegal Argument Exception]");
    }

    public static AccountResult unauthorized(){
        return new AccountResult(401,"Unauthorized [Current request requires user authentication | invalid token]");
    }

    public static AccountResult noPerm(){
        return new AccountResult(403,"Forbidden [No request permission]");
    }

    /////////////////////////////////自定义code///////////////////

    public static AccountResult unknownAccount(){
        return new AccountResult(40001,"unknown account [Please confirm your account]");
    }
    public static AccountResult credentialsException(){
        return new AccountResult(40002,"did not match the expected credentials [Please confirm your credentials]");
    }
}
