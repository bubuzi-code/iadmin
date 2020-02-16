package club.mikusun.iadmin.webutils.result.account;

import club.mikusun.iadmin.webutils.result.Result;

public class AccountResult extends Result {
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
        return new AccountResult(401,"Unauthorized [Current request requires user authentication]");
    }

    public static AccountResult noPerm(){
        return new AccountResult(403,"Forbidden [No request permission]");
    }

}
