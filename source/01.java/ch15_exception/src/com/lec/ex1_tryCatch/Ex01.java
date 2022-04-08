package com.lec.ex1_tryCatch;

import java.util.Scanner;
// 예외처리 없음
public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("사칙연산을 할 첫번째 수는 ? ");
		int i = scanner.nextInt();
		System.out.print("사칙연산을 할 두번째 수는 ? ");
		int j = scanner.nextInt();
		System.out.println("i = "+i+", j = "+j);
		System.out.println("i * j = "+(i*j));
		System.out.println("i / j = "+(i/j)); // 예외가 발생할 수 있는 부분
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		scanner.close();
		
	}
}
