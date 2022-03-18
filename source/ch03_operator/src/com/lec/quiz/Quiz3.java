package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요 : ");
		int n1 = scanner1.nextInt();
		System.out.print("두번째 수를 입력하세요 : ");
		int n2 = scanner2.nextInt();
		char result1 = n1==n2? 'O' : 'x';
		char result2 = n1>n2 ? 'O' : 'X';
		System.out.println("두 수가 같나요? \t"+result1);
		System.out.println("첫번째 수가 더 큰가요? \t"+result2);

	}

}