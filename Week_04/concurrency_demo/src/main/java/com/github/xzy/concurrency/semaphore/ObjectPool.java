package com.github.xzy.concurrency.semaphore;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

public class ObjectPool<T, R> {
	final List<T> pool;
	final Semaphore sem;

	public ObjectPool(int size, T t) {
		pool = new Vector<>();
		for (int i = 0; i < size; i++) {
			pool.add(t);
		}
		sem = new Semaphore(size);
	}

	R exec(Function<T, R> func){
		T t = null;
		try {
			sem.acquire();
			try {
				t = pool.remove(0);
				return func.apply(t);
			}finally {
				sem.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
