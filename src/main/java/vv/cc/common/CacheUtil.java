package vv.cc.common;

import org.springframework.data.redis.core.RedisTemplate;
import vv.cc.cache.RedisParentDao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by melo on 2016/12/9.
 */
public class CacheUtil {

    public static String pass(HttpServletRequest request, String key, RedisTemplate<String,String> redisTemplate){
        RedisParentDao redis = new RedisParentDao(redisTemplate);
        return redis.getValue(key);
    }
}
