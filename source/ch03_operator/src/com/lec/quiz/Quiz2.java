package com.lec.quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		int n1 = scanner.nextInt();
		String result = n1%2 == 0 ? "�� ���� ¦���Դϴ�" : "�� ���� Ȧ���Դϴ�";
		System.out.println(result);
		
	}

}
