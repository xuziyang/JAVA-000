package com.github.xzy.concurrency.api;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo01 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 2);

		//线程池
		//ExecutorService es = Executors.newCachedThreadPool();
		//es.submit(futureTask);

		//线程
		Thread t1 = new Thread(futureTask);
		t1.start();

		System.out.println(futureTask.get());
	}
}
