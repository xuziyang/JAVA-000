package com.github.xzy.concurrency.volitail;

import java.util.concurrent.TimeUnit;

public class TestVolatile {
	public static long[] arr = new long[20];

	public static void main(String[] args) throws Exception {
		//线程1
		new Thread(() -> {
			//Thread A
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			arr[19] = 2;
		}).start();
		//线程2
		new Thread(() -> {
			//Thread B
			while (arr[19] != 2) {
			}
			System.out.println("Jump out of the loop!");
		}).start();
	}

}
