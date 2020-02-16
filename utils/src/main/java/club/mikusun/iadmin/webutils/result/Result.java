package club.mikusun.iadmin.webutils.result;


import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Result implements Serializable {
    private int code;
    private String massage;
    private Object data;

    protected Result(int code){
        this(code,"",null);
    }
    protected Result(int code,String massage){
        this(code,massage,null);
    }
    protected Result(int code,String massage,Object data){
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public String toJson(){
        return JSON.toJSONString(this);
    }
}
