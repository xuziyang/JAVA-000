package com.github.xzy.concurrency.stampedlock;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampLockCpuDemo {
	static Thread[] holdCpuThreads = new Thread[3];
	static final StampedLock lock = new StampedLock();

	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			long readLong = lock.writeLock();
			LockSupport.park();
			lock.unlockWrite(readLong);
		}).start();
		Thread.sleep(100);


		for (int i = 0; i < 3; i++) {
			holdCpuThreads[i] = new Thread(new HoldCPUReadThread());
			holdCpuThreads[i].start();
		}
		Thread.sleep(1000);

		//线程中断后，会占用cpu
		for (int i = 0; i < 3; i++) {
			holdCpuThreads[i].interrupt();
		}
	}

	private static class HoldCPUReadThread implements Runnable {
		@Override
		public void run() {
			long lockr = lock.readLock();
			System.out.println(Thread.currentThread().getName() + " 获得读锁");
			lock.unlockRead(lockr);
		}
	}

}
