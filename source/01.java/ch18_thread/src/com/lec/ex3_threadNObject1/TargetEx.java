package com.lec.ex3_threadNObject1;

public class TargetEx implements Runnable {
	private int num = 0;
	@Override
	public void run() {
		for(int i = 0 ; i<10 ; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}			
		}
	}
	private synchronized void out() {
		if(Thread.currentThread().getName().equals("A")) { // "A" Thread일 경우
			System.out.println("~ ~ ~ A Thread 수행중 ~ ~ ~");
			num++;
		}
		System.out.println(Thread.currentThread().getName()+"의 num = "+num);
	}
}
