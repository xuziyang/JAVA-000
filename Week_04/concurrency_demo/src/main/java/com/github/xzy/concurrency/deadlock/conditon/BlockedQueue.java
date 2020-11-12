package com.github.xzy.concurrency.deadlock.conditon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedQueue<T> {

	private final int capacity = 10;
	private volatile int size;

	private Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	//入队
	void enq(T x){
		lock.lock();
		try{
			while (size == capacity) {
				notFull.await();
			}
			//入队操作
			notEmpty.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	//出队
	void deq() {
		lock.lock();
		try {
			while (size == 0) {
				notEmpty.await();
			}
			//出队操作
			notFull.signal();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
}
