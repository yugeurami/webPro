package com.lec.condition;

public class Quiz02 {

	public static void main(String[] args) {
		int num1 = 27;
		int num2 = 32;
		int max;
		if(num1>num2){
			max = num1; // 블럭 안에서 선언한 변수는 블럭 안에서만 존재함
		} else {
			max = num2;
		}
		System.out.println(max);
	}

}
