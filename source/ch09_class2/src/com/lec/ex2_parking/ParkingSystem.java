package com.lec.ex2_parking;

public class ParkingSystem {
	private String no;
	private int inTime;

	
	public ParkingSystem() {	}
	public ParkingSystem(String no, int inTime) {
		this.no = no;
		this.inTime = inTime;
		System.out.println("\""+no+"\"님 어서오세요");
		System.out.println("* 입차시간 : "+inTime+"시");
	}
	
	public void outParking(int outTime) {
		int fee = (outTime - inTime)*2000;
		System.out.println("\""+no+"\"님 안녕히 가세요");
		System.out.println("* 입차시간 : "+inTime+"시");
		System.out.println("* 출차시간 : "+outTime+"시");
		System.out.println("* 주차요금 : "+fee+"원");
	}
		
}
