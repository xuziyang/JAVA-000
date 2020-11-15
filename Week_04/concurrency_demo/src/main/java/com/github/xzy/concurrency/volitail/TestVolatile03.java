package com.github.xzy.concurrency.volitail;

import java.util.concurrent.TimeUnit;

public class TestVolatile03 {

	private static volatile User u = new User();

	public static void main(String[] args) {
		new Thread(() -> {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			u.setName("xzy");
		}).start();

		new Thread(() -> {
			while (true) {
				if (u.getName() != null) {
					break;
				}
			}
		}).start();
	}
}
