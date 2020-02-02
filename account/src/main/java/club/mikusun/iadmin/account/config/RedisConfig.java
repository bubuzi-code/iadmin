package club.mikusun.iadmin.account.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Configuration
public class RedisConfig {
//    public KeyGenerator generator(RedisProperties redisProperties){
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object o, Method method, Object... objects) {
//                StringBuilder stringBuilder = new StringBuilder();
//                return null;
//            }
//        }
//    }
}
