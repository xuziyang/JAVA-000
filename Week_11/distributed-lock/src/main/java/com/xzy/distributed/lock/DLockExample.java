package com.xzy.distributed.lock;

public class DLockExample {
    
    public static void main(String[] args) {
        MyJedis jedis = new MyJedis();
    
        DLock lock = jedis.getLock("lock");
        boolean locked = lock.lock();
        System.out.println(locked);
        
        lock.unlock();
    }
    
}
