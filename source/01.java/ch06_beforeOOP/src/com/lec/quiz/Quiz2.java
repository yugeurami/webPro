package com.lec.quiz;

import java.util.Scanner;

// 사용자로부터 수를 입력받아 절대값을 출력(단, 매개변수를 받아 절대값을 리턴하는 함수 이용)
public class Quiz2 {

	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		su = sc.nextInt();
		System.out.printf("이 수의 절대값은 %d입니다", abs(su));
		sc.close();
	}
	
	private static int abs(int su) {
		int result = su>=0 ? su : -su;
		return result;
	}

}
