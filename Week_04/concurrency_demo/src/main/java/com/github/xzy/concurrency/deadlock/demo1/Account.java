package com.github.xzy.concurrency.deadlock.demo1;

public class Account {
	private String name;
	private int balance;

	public Account(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}

	// 转账
	void transfer(Account target, int amt) {
		// 锁定转出账户
		synchronized (this) {
			// 锁定转入账户
			synchronized (target) {
				if (this.balance > amt) {
					this.balance -= amt;
					target.balance += amt;
				}
				System.out.println(name + "向" + target.name + "转账：" + amt + "元");
			}
		}
	}
}