package com.lec.ex2_parking;

public class ParkingSystemMain {

	public static void main(String[] args) {
		ParkingSystem p1 = new ParkingSystem("11라 1111", 12);
		ParkingSystem p2 = new ParkingSystem("22루 2222", 12);
		p1.outParking(); //사용자에게 ouTime받기
		p2.outParking(15);
	}

}
