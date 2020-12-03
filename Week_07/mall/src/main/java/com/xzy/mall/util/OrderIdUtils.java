package com.xzy.mall.util;

public class OrderIdUtils {
    
    private static SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
    
    public static long nextId() {
        return idWorker.nextId();
    }
}
