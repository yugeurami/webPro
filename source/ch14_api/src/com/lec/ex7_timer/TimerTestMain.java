package com.lec.ex7_timer;

import java.util.Timer;

public class TimerTestMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		Timer timer = new Timer(true); // 프로그램이 끝나도 계속 timer 상주
		TimerTaskEx1 task1 = new TimerTaskEx1();
		TimerTaskEx2 task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000); // 2초 후에 task1 수행
		timer.schedule(task2, 1000, 500); // 1초 후에 0.5초마다 task.run()수행
		// 3초 동안 잠깐 멈춤
		Thread.sleep(3000);
		System.out.println("끝");
	}

}
