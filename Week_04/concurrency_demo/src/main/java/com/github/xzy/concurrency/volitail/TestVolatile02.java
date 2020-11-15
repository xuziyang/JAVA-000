package com.github.xzy.concurrency.volitail;

import java.util.concurrent.TimeUnit;

public class TestVolatile02 {
	private static  User[] users = new User[10];

	public static void main(String[] args) {
		new Thread(() -> {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			users[9] = new User();
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			users[9].setName("xzy");
		}).start();

		new Thread(() -> {
			while (true) {
				if (users[9] != null && "xzy".equals(users[9].getName())) {
					break;
				}
			}
		}).start();
	}
}
