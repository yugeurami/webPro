package com.lec.condition;

public class Ex05_evenOdd {

	public static void main(String[] args) {
		int num = 3;
		// if
		if (num%2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}
		
		//switch
		switch(num%2) {
		case 0: System.out.println("짝수");break;
		default: System.out.println("홀수");break;
		}
		
		//삼항연산자
		System.out.println(num%2==0 ? "짝수" : "홀수");

	}

}
