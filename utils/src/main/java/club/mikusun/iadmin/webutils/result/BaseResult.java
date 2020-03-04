package club.mikusun.iadmin.webutils.result;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.java.Log;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@Log
public abstract class BaseResult implements Serializable {

    private int code;
    private String massage;
    private Object data;
//    private String dataFormat;

    protected BaseResult(){
        this(200,"",null);
    }
    protected BaseResult(int code){
        this(code,"",null);
    }
    protected BaseResult(int code,String massage){
        this(code,massage,null);
    }
    protected BaseResult(int code,String massage,Object data){
        this.code = code;
        this.massage = massage;
        this.data = data;

    }

    public String toJson(){
        return JSON.toJSONString(this);
    }
    public boolean isSuccess(){
        boolean sign = this.code == 0;
        if(!sign){
            log.info(massage);
        }
        return sign;
    }
}
