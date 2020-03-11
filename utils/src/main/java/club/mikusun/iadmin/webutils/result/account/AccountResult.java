package club.mikusun.iadmin.webutils.result.account;

import club.mikusun.iadmin.webutils.result.BaseResult;

/**
 * 账户响应通用封装
 */
public class AccountResult extends HttpResult {
    protected AccountResult(int code) {
        super(code);
    }

    protected AccountResult(int code, String massage) {
        super(code, massage);
    }

    protected AccountResult(int code, String massage, Object data) {
        super(code, massage, data);
    }


    /////////////////////////////////自定义code///////////////////

    public static AccountResult unknownAccount(){
        return new AccountResult(40001,"unknown account [Please confirm your account]");
    }
    public static AccountResult credentialsException(){
        return new AccountResult(40002,"did not match the expected credentials [Please confirm your credentials]");
    }
}
