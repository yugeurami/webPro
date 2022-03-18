package com.lec.method;

public class Arithmetic {
	public int abs(int value) {
		int result = (value >= 0) ? value : -value;
		return result;
	} 
	
	public static int sum(int to) { 
		int result = 0;
		for (int i = 1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	
	public static int sum(int from, int to) { 
		int result = 0;
		for (int i = from ; i<=to ; i++) {
			result += i;
		}
		return result; 
	}
	
	public static String evenOdd(int tot) {
		return tot%2==0 ? "짝수입니다" : "홀수입니다";
	}
}
