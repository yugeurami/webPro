package com.lec.ex2_parking;

import java.util.Scanner;

import com.lec.cons.Constant;

public class ParkingSystem {
	private String no;
	private int inTime;
	private int outTime;
	private int fee;
//	private final int HOURLYPARKINGRATE = 2000; //다른 곳에서 바꿀 수 없음
	
	public ParkingSystem() {	}
	public ParkingSystem(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.println("\""+no+"\"님 어서오세요");
		System.out.println("* 입차시간 : "+inTime+"시");
		for (int t = 0 ; t<30 ; t++) {
			System.out.print("*");
		}System.out.println();
	}
	
	public void outParking(int outTime) {
		this.outTime = outTime;
		fee = (outTime - inTime) * Constant.HOURLYPARKINGRATE; // 변하지 않는 상수들만 묶은 꾸러미를 만들어 두면 유지 보수가 쉽다
		System.out.println("\""+no+"\"님 안녕히 가세요");
		System.out.println("* 입차시간 : "+inTime+"시");
		System.out.println("* 출차시간 : "+outTime+"시");
		System.out.println("* 주차요금 : "+fee+"원");
		for (int t = 0 ; t<30 ; t++) {
			System.out.print("*");
		}System.out.println();
	}
	public void outParking() {
		Scanner scanner = new Scanner(System.in);
		System.out.print(inTime+"시에 들어오셨는데 몇시에 출차하시나요? ");
		outTime = scanner.nextInt();
		outParking(outTime);
		scanner.close();
	}
		
}
