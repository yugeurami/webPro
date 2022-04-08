package com.lec.ex1_runnable;
// "안녕하세요 10번" 하는 target
public class TargetEx01 implements Runnable {

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
