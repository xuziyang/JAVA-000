package com.github.xzy.concurrency.deadlock.demo2;

public class Account {
	private Allocator actr;
	private int balance;

	public void transfer(Account target, int amt) {
		while (!actr.apply(this, target))
			;

		try {
			synchronized (this) {
				synchronized (target) {
					if (this.balance > amt) {
						this.balance -= amt;
						target.balance += amt;
					}
				}
			}
		} finally {
			actr.free(this, target);
		}
	}
}

