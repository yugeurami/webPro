package com.lec.ex;
// 1~10까지 정수의 합을 출력하고 그 합이 짝수인지 홀수인지 출력
public class Ex02 {
	public static void main(String[] args) {
		
		int tot = sum(10); //sum 호출
		System.out.print("1~10까지 누적합은 "+tot+", ");
		System.out.println(evenOdd(tot));
		
		tot = sum(10, 100);
		System.out.print("10~100까지 누적합은 "+tot+", ");
		System.out.println(evenOdd(tot));
	}
	
	private static int sum(int to) { // 함수의 오버로딩
		int result = 0;
		for (int i = 1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	
	private static int sum(int from, int to) { // from ~ to까지 누적한 결과 return
		int result = 0;
		for (int i = from ; i<=to ; i++) {
			result += i;
		}
		return result; // return이 나오면 호출한 곳으로 값을 출력
	}
	
	private static String evenOdd(int tot) {
		return tot%2==0 ? "짝수입니다" : "홀수입니다";
//		if(tot%2 == 0) {
//			return "짝수입니다";
//		}else {
//			return "홀수입니다";
//		} 
	}

}
