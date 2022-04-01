package com.lec.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;
// 예외 : ArithmeticException
public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j = 1;
		do {
			try {
				System.out.print("사칙연산을 할 첫번째 수는 ? ");
				i = scanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("예외 메세지 : "+e.getMessage());
				System.out.println("정수를 반드시 입력하세요");
				scanner.nextLine(); // 버퍼를 지우는 목적
			}	
		}while(true);
		System.out.print("사칙연산을 할 두번째 수는 ? ");
		try {
			j = scanner.nextInt();
			System.out.println("i = "+i+", j = "+j);
			System.out.println("i * j = "+(i*j));
			System.out.println("i / j = "+(i/j));	
		}catch(InputMismatchException e) { // 위에서 부터 실행 상위에 Exception을 쓰면 안됨
			System.out.println("예외 메세지 : "+e.getMessage());
			System.out.println("두번째 수를 잘못 입력하시면 1로 초기화 됨");
			scanner.nextLine();
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println("모든 예외는 다 이쪽으로"+e.getMessage());
		}
		 
		System.out.println("i + j = "+(i+j));
		System.out.println("i - j = "+(i-j));
		System.out.println("DONE");
		scanner.close();
		
	}
}
