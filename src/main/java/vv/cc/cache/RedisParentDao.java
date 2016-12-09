package vv.cc.cache;

import ch.qos.logback.core.util.TimeUtil;
import org.omg.CORBA.TIMEOUT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * Created by melo on 2016/12/9.
 */
public class RedisParentDao {

    /**
     * 日志记录
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    protected RedisTemplate<String,String> redisTemplate;

    public RedisParentDao(RedisTemplate<String,String> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * 缓存value操作
     * @param PREFIX
     * @param k
     * @param v
     * @param time
     * @return
     */
    public boolean cacheValue(String PREFIX,String k,String v,long time){
        String key = PREFIX + k;
        try {
            ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key,v);
            if (time > 0)
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            return true;
        } catch (Throwable t){
            logger.error("缓存["+key+"]失败，value["+v+"]",t);
        }
        return false;
    }

    /**
     * 判断缓存key是否存在
     * @param key
     * @return
     */
    public boolean containsValueKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Throwable t){
            logger.error("判断缓存key是否存在失败key["+key,t);
        }
       return false;
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public String getValue(String key){
        try {
            ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
            return valueOperations.get(key);
        } catch (Throwable t){
            logger.error("获取缓存失败",t);
        }
        return null;
    }

    /**
     * 移除缓存
     * @param key
     * @return
     */
    public boolean remove(String key){
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Throwable t){
            logger.error("获取缓存失败",t);
        }
        return false;
    }
}
