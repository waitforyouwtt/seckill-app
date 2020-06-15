package com.yidiandian.utils;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/6/10 22:28
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class RedisLockUtil {

    private static Jedis jedis = new Jedis("127.0.0.1",6379);
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;


    public static boolean tryGetDistributedLock(String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    public static boolean releaseDistributedLock(String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        jedis.set("testkey","testvalue");
        String value = jedis.get("testkey");
        System.out.println(value);
    }
}
