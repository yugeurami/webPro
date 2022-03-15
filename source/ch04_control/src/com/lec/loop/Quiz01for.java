package com.lec.loop;
//1~10까지의 곱
public class Quiz01for {

	public static void main(String[] args) {
		int tot = 1;
		for (int i = 1; i<=10 ; i++) {
			tot *= i; 
		}
		System.out.println("1부터 10까지의 누적 곱은 "+tot);
	}

}
