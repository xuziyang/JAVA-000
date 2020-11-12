package com.github.xzy.concurrency.deadlock.demo3;

import java.util.HashSet;
import java.util.Set;

/**
 * 这个类需是单例的
 */
public class Allocator {

	private Set<Object> als = new HashSet<>();

	synchronized void apply(Object from, Object to) {
		if (als.contains(from) || als.contains(to)) {
			try {
				this.wait();
			}catch (InterruptedException e) {
			}
		} else {
			als.add(from);
			als.add(to);
		}
	}

	synchronized void free(Object from, Object to) {
		als.remove(from);
		als.remove(to);
		notifyAll();
	}
}
