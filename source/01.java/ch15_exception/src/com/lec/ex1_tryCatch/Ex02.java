package com.lec.ex1_tryCatch;

import java.util.Scanner;
// 예외처리 추가
public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("사칙연산을 할 첫번째 수는 ? ");
		int i = scanner.nextInt();
		System.out.print("사칙연산을 할 두번째 수는 ? ");
		int j = scanner.nextInt();
		System.out.println("i = "+i+", j = "+j);
		System.out.println("i * j = "+(i*j));
		try {
			System.out.println("i / j = "+(i/j)); // 예외가 발생할 수 있는 부분
		}catch(ArithmeticException e) {
			// 예외가 발생할 경우 우회적으로 수행할 로직
			System.out.println("예외 메세지 : "+e.getMessage()); // 예외메세지만 출력
			//e.printStackTrace(); // 예외 사항을 자세히 출력
		}
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		scanner.close();
		
	}
}
