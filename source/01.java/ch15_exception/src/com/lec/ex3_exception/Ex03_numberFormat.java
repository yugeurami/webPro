package com.lec.ex3_exception;

public class Ex03_numberFormat {

	public static void main(String[] args) {
		//int i = Integer.parseInt(""); // 빈 스트링은 숫자로 변환이 안됨 예외발생
		int i = Integer.parseInt("100  ".trim());
		System.out.println(i);
	}

}
