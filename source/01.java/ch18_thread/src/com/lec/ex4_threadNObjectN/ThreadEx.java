package com.lec.ex4_threadNObjectN;

public class ThreadEx extends Thread{
	private int num = 0;
	
	public ThreadEx(String name) {
		super(name);
	}
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
	public int getNum() {
		return num;
	}
}
