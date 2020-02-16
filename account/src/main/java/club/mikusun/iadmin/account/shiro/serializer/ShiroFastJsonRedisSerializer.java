package club.mikusun.iadmin.account.shiro.serializer;

import club.mikusun.iadmin.cache.util.FastJsonRedisSerializer;
import com.alibaba.fastjson.JSON;
import org.crazycake.shiro.exception.SerializationException;
import org.crazycake.shiro.serializer.RedisSerializer;

public class ShiroFastJsonRedisSerializer extends FastJsonRedisSerializer implements RedisSerializer {

}
