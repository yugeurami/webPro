package com.lec.quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		System.out.print("ù��° ���� �Է��ϼ��� : ");
		int n1 = scanner1.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ��� : ");
		int n2 = scanner2.nextInt();
		char result1 = n1==n2? 'O' : 'x';
		char result2 = n1>n2 ? 'O' : 'X';
		System.out.println("�� ���� ������? \t"+result1);
		System.out.println("ù��° ���� �� ū����? \t"+result2);

	}

}
