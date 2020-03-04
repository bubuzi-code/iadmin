package club.mikusun.iadmin.webutils.result.account;

import club.mikusun.iadmin.webutils.result.BaseResult;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
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

    public <T> T ifPresentAndConvertObj(Class<T> clazz ){
        return ifPresentAndConvertObj(clazz , false);
    }


    public <T> T ifPresentAndConvertObj(Class<T> clazz , boolean isReturn){
        if(this.isSuccess()&& this.getData()!=null && this.getData().getClass() == JSONObject.class){
            JSONObject jsonObject = (JSONObject) this.getData();
            return jsonObject.toJavaObject(clazz);
        }
        if(isReturn){
            return null;
        }
        throw new ClassCastException("Abnormal");
    }
    public <T> List<T> ifPresentAndConvertList(Class<T> clazz){
        return ifPresentAndConvertList(clazz , false);
    }
    public <T> List<T> ifPresentAndConvertList(Class<T> clazz , boolean isReturn){
        if(this.isSuccess()&& this.getData()!=null && this.getData().getClass() == JSONArray.class){
            JSONArray jsonArray = (JSONArray) this.getData();
            return jsonArray.toJavaList(clazz);
        }
        if(isReturn){
            return null;
        }
        throw new ClassCastException("Abnormal");
    }

    public static Result success(){
        return new Result(0 , "success");
    }
    public static Result success(Object data){
        return new Result(0 , "success" , data);
    }

    public static Result error(){
        return new Result(1 , "Error occurred");
    }
    public static Result error(String error){
        return new Result(1 , error);
    }
    public static Result error(String error , Object data){
        return new Result(1 , error , data);
    }

}
