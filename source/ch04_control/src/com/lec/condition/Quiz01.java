package com.lec.condition;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է����ּ��� : ");
		num = sc.nextInt();
		if (num > 0) {
			System.out.println("���밪�� :"+ num);
		}else {
			System.out.println("���밪�� :"+ -num);
		}
		sc.close();

	}

}
