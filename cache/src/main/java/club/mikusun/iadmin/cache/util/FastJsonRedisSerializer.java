package club.mikusun.iadmin.cache.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Class<T> clazz;

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if(null == t){
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName)
                .getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if(null == bytes || bytes.length <= 0){
            return null;
        }
        String value = new String(bytes);
        return (T) JSON.parse(value);
    }
}
