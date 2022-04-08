package com.lec.ex;
// 1~10까지 정수의 합을 출력하고 그 합이 짝수인지 홀수인지 출력
public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i = 1 ; i<11 ; i++) {
			tot += i;
		}
		System.out.println("1부터 10까지 정수의 합은 "+tot+"입니다");
		String msg;
		if(tot%2==0) {
			msg = "짝수입니다";
		}else {
			msg = "홀수입니다";
		}
		System.out.println(msg);
	}

}
