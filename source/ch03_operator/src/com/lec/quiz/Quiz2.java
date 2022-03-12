package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int n1 = scanner.nextInt();
		String result = n1%2 == 0 ? "이 수는 짝수입니다" : "이 수는 홀수입니다";
		System.out.println(result);
		
	}

}
