package com.xzy.distributed.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.UUID;

public class DLock {
    
    private String key;
    
    private String value;
    
    private Jedis jedis;
    
    DLock(String key, Jedis jedis) {
        this.key = key;
        this.value = genUUID();
        this.jedis = jedis;
    }
    
    public boolean lock(Long leaseTimeInSeconds) {
        SetParams params = new SetParams();
        params.ex(5L);  // 设置超时时间
        params.nx();    // 若锁不存在才进行写操作
        return jedis.set(key, value, params) != null;
    }
    
    public boolean lock() {
        return lock(0L);
    }
    
    public void unlock() {
        String lua = "if redis.call(\"get\",KEYS[1]) == ARGV[1] then\n" +
                "    return redis.call(\"del\",KEYS[1])\n" +
                "else\n" +
                "    return 0\n" +
                "end";
        jedis.eval(lua, 1, key, value);
    }
    
    private String genUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }
}
