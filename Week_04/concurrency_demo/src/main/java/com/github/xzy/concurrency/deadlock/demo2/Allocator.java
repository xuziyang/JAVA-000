package com.github.xzy.concurrency.deadlock.demo2;

import java.util.HashSet;
import java.util.Set;

/**
 * 这个类需是单例的
 */
public class Allocator {

	private Set<Object> als = new HashSet<>();

	synchronized boolean apply(Object from, Object to) {
		if (als.contains(from) || als.contains(to)) {
			return false;
		} else {
			als.add(from);
			als.add(to);
		}
		return true;
	}

	synchronized void free(Object from, Object to) {
		als.remove(from);
		als.remove(to);
	}
}
