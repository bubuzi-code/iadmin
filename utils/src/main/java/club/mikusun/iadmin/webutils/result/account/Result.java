package club.mikusun.iadmin.webutils.result.account;

import club.mikusun.iadmin.webutils.result.BaseResult;

public class Result extends BaseResult {
    protected Result(int code) {
        super(code);
    }

    protected Result(int code, String massage) {
        super(code, massage);
    }

    protected Result(int code, String massage, Object data) {
        super(code, massage, data);
    }

    public static Result success(){
        return new Result(0 , "success");
    }
}
