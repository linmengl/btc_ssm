package com.test;

import java.util.concurrent.CountDownLatch;

public class Test2 {

	private static int a = 0;


	private static CountDownLatch latch = new CountDownLatch(2000);
	private static CountDownLatch latch2 = new CountDownLatch(2000);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 2000; i++) {
			new Thread(new Worker()).start();
			latch.countDown();
		}
		//Thread.sleep(5000);
		latch2.await();
		System.out.println(a);
	}

	static class Worker implements Runnable {

		@Override
		public void run() {
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			a++;
			latch2.countDown();
		}
	}
}


