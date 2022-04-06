package com.lec.ex2_thread;
// TargetEx02 = new TargetEx02();
public class TargetEx02 extends Thread{
	@Override
	public void run() {
		for(int i = 0 ; i<10; i++) {
			System.out.println(Thread.currentThread().getName());
			System.out.println("반갑습니다 - "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			} 
		}
	}
}
