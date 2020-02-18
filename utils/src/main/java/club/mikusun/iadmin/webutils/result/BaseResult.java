package club.mikusun.iadmin.webutils.result;


import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public abstract class BaseResult implements Serializable {
    private int code;
    private String massage;
    private Object data;

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
}
