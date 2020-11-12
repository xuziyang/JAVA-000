package com.github.xzy.concurrency.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo01 {
	final StampedLock sl = new StampedLock();

	public void aaa() {
		long stamp = sl.readLock();
		try {
			//业务代码
		}finally {
			sl.unlock(stamp);
		}

		stamp = sl.writeLock();
		try {
			//业务代码
		}finally {
			sl.unlock(stamp);
		}
	}
}
