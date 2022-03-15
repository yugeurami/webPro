package com.lec.loop;
// 구구단 표 출력
public class Quiz04for {

	public static void main(String[] args) {
		for(int i = 1 ; i<=9 ; i++) {
			for (int j = 2 ; j <= 9 ; j++) {
				System.out.printf("%d*%d=%d \t", j, i, j*i);
			} // for- j
			System.out.println(); // 개행
		} // for -i

	} // main

}
