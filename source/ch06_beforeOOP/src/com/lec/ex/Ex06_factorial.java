package com.lec.ex;

import java.util.Scanner;

// ����ڷκ��� ���� �Է¹޾� �Է¹��� ��(3) ! = 3*2*1 (���丮�� ����ϴ� �޼ҵ� �̿�)
public class Ex06_factorial {
	
	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("����� �Է��ϼ��� : ");
			su = sc.nextInt();
		} while(su<=0);
		long result = factorial(su);
		System.out.printf("�Է��Ͻ� %d! = %d", su, result);
		sc.close();
	}
	
	private static long factorial(int su) { // su�� 1�ʰ� �� ��� : su * factorial(su-1);
		if (su==1) {
			return 1;
		}else {
			return su * factorial(su-1);
		}
	}
	
//	private static long factorial(int su) {
//		int result = 1;
//		for(int i = su ; i>0 ; i--) {
//			result *= i;
//		}
//		return result;
//	}
	
	

}
