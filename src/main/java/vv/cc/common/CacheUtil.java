package vv.cc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import vv.cc.cache.RedisParentDao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by melo on 2016/12/9.
 */
public class CacheUtil {


    public static String pass(HttpServletRequest request, String key, RedisTemplate<String,String> redisTemplate){
        RedisParentDao redis = new RedisParentDao(redisTemplate);
        //判断缓存是否存在
            if(redis.containsValueKey(key)){
                return redis.getValue(key);
            }else{
                redis.cacheValue(key,key,"你好，spring-boot",3);
            }
        return redis.getValue(key);
    }
}
