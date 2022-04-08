package com.lec.ex2_thread;
// Thread t1 = new Thread(target, "A")
// Thread t1 - new ThreadEx01();
// Thread t1 - new ThreadEx01("A");
public class TargetEx01 extends Thread{
	public TargetEx01() {	}
	public TargetEx01(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i = 0 ; i<10; i++) {
			System.out.println("안녕하세요 - "+i);
			try {
				Thread.sleep(500);// 현재 작업을 0.5초 동안 대기 상태로
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			} 
		}
	}
}
