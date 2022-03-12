package com.lec.ex;

public class VarEx06 {
	public static void main(String[] args) {
		int i1 = 10; 			// 4byte
		long l = 2200000000l;   // 8byte
		double d1 = 10;         // 8bye = 4byte 묵시적 형변환 (작은 byte값을 큰 byte공간에)
		System.out.println("d1="+d1);
		double d2 = 10.19;
		int i2 = (int)d2;       // 명시적인 형변환(데이터 손실이 발생할 수도 있음)
		System.out.println("i2="+i2);
	}
}
