package com.lec.ex;
// 삼항연산자    (조건) ? (참일 경우 취할 값/식) : (거짓일 결우 취할 값/식)
public class Ex06 {

	public static void main(String[] args) {
		int h = 100;
		String result;
//		if (h%2==0) {
//			result = "짝수";
//		}
//		else {
//			result = "홀수";
//		}
		
		result = (h%2==0) ? "짝수" : "홀수";
		
		System.out.println(result);

	}

}
