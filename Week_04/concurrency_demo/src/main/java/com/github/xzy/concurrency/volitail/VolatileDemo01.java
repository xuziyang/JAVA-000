package com.github.xzy.concurrency.volitail;

public class VolatileDemo01 {

	private static volatile int[] a = new int[10];

	public static void main(String[] args) {
		a[1] = 2;
		a[2] = 3;

		a = null;
	}

}
