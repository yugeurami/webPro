package com.lec.ex;

public class VarEx05 {

	public static void main(String[] args) {
		float f1, f2;
		f1 = 10.1F;
		f2 = 100.1F;
		System.out.println("f1="+f1);
		f1 = 10.0000017f;
		double d = 10.0000017;
		System.out.println("f1="+f1);
		System.out.println("d="+d);
		f1 = 10.1f;
		d = 10.1;
		if (f1==d) 
			System.out.println("두 변수는 같다.");
		else 
			System.out.println("두 변수는 다르다.");
		
		
	}

}