package com.lec.ex6_wrapper;

public class Ex03_method {

	public static void main(String[] args) {
		System.out.println("스트링을 정수로 바꾸는 함수 : Integer.parseInt(문자열)");
		int i = Integer.parseInt("10");
		System.out.println(i);
		System.out.println("정수를 스트링으로 바꾸는 함수 : String.valueOf(숫자)");
		String monthStr = ""+12; // "12"
		monthStr = String.valueOf(12);
		System.out.println(monthStr);
	}

}
