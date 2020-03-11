package club.mikusun.iadmin.webutils.result.account;

import club.mikusun.iadmin.webutils.result.BaseResult;

/**
 * http通用响应封装
 */
public class HttpResult extends BaseResult {
    protected HttpResult(int code) {
        super(code);
    }

    protected HttpResult(int code, String massage) {
        super(code, massage);
    }

    protected HttpResult(int code, String massage, Object data) {
        super(code, massage, data);
    }

    public static HttpResult badRequest(){
        return badRequest("Illegal Argument Exception");
    }
    public static HttpResult badRequest(String msg){
        return new HttpResult(400,String.format("bad request [ %s ]" , msg));
    }

    public static HttpResult unauthorized(){
        return new HttpResult(401,"Unauthorized [Current request requires user authentication | invalid token]");
    }

    public static HttpResult noPerm(){
        return new HttpResult(403,"Forbidden [No request permission]");
    }

}
