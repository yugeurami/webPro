package com.lec.ex7_timer;

import java.util.TimerTask;

public class TimerTaskEx1 extends TimerTask {

	@Override
	public void run() {
		System.out.println("작업1 : 2초 후에 한번 수행될 예정인 TimerTask");
	}
	
}
