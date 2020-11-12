package com.github.xzy.concurrency.stampedlock;

import java.util.Currency;
import java.util.concurrent.locks.StampedLock;

public class Point {
	private double x,y;
	private final StampedLock sl = new StampedLock();

	void move(double deltaX, double deltaY) {
		long stamp = sl.writeLock();
		try {
			x += deltaX;
			y += deltaY;
		}finally {
			sl.unlock(stamp);
		}
	}

	double distanceFromOrigin() {
		long stamp = sl.tryOptimisticRead();
		double currentX = x, currentY = y;
		if (!sl.validate(stamp)) {
			stamp = sl.readLock();
			try {
				currentX = x;
				currentY = y;
			}finally {
				sl.unlock(stamp);
			}
		}
		return Math.sqrt(currentX * currentX + currentY * currentY);
	}
}
