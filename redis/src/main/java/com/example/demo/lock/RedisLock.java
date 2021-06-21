package com.example.demo.lock;

import com.example.demo.JedisPoolUtils;
import redis.clients.jedis.Jedis;

/**
 * @author Wanghj
 * @Package com.example.demo.lock
 * @date 2021/4/25 9:45
 */
public class RedisLock {
    private final String lock_key = "redis_lock";
    private long LockTimeOut = 30000L;
    private long timeout= 99999;

    private void lock(String id){
        Jedis jedis = JedisPoolUtils.getJedis();
        String set = jedis.set(lock_key, id);
    }
}
