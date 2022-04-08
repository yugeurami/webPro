package com.lec.ex3_threadNObject1;

public class TargetExTest {

	public static void main(String[] args) {
		TargetEx target = new TargetEx();
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		threadA.start();
		threadB.start();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {		}
		System.out.println("main 함수 끝");
	}

}
