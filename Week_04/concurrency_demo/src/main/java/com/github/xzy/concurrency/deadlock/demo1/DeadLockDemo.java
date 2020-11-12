package com.github.xzy.concurrency.deadlock.demo1;

public class DeadLockDemo {

	public static void main(String[] args) {
		Account a = new Account("A", 100);
		Account b = new Account("B", 200);

		Thread a2b = new Thread(() -> {
			while (true) {
				a.transfer(b, 1);
			}
		});

		Thread b2a = new Thread(() -> {
			while (true) {
				b.transfer(a, 1);
			}
		});

		a2b.start();
		b2a.start();
	}



}

