package com.xzy.distributed.lock;

import redis.clients.jedis.Jedis;

public class MyJedis {
    private Jedis jedis;
    
    public MyJedis() {
        this("127.0.0.1", 6379);
    }
    
    public MyJedis(String host, int port) {
        this.jedis = new Jedis(host, port);
    }
    
    public DLock getLock(String key) {
        return new DLock(key, jedis);
    }
}
