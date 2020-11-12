package com.github.xzy.concurrency.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo1 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Result r = new Result();
		r.setAaa("a");

		Future<Result> future = executor.submit(new Task(r), r);
		Result fr = future.get();
		System.out.println(fr);
	}

	private static class Task implements Runnable{
		Result r;

		public Task(Result r) {
			this.r = r;
		}

		@Override
		public void run() {
			String aaa = r.getAaa();
			r.setXxx("x");
		}
	}

	private static class Result {
		private String aaa;
		private String xxx;

		public String getAaa() {
			return aaa;
		}

		public void setAaa(String aaa) {
			this.aaa = aaa;
		}

		public String getXxx() {
			return xxx;
		}

		public void setXxx(String xxx) {
			this.xxx = xxx;
		}

		@Override
		public String toString() {
			return "Result{" + "aaa='" + aaa + '\'' + ", xxx='" + xxx + '\'' + '}';
		}
	}

}
