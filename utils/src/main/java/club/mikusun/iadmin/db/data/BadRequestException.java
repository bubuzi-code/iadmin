package club.mikusun.iadmin.db.data;
//非法请求异常
public class BadRequestException extends IllegalArgumentException {
    private static final String msg = "This request is illegal";
    public BadRequestException(){
        super(msg);
    }
    public BadRequestException(String msg){
        super(String.format("%s\t[ %s ]" , BadRequestException.msg , msg));
    }
}
