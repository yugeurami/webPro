package com.lec.loop;
//1~10까지 숫자 중 짝수의 합
public class Quiz02for {

	public static void main(String[] args) {
		int tot = 0;
		
//		for (int i = 0 ; i<11 ; i+=2) {
//			tot += i;
//		}
		
		for (int i = 1 ; i<=10 ; i++) {
			if(i%2==0) {
				tot += i;
			}
		}
		System.out.println("1부터 10까지의 짝수의 합은 "+tot);
	}

}
