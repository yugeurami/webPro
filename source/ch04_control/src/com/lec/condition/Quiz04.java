package com.lec.condition;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.print("����(0),����(1),��(2) �� �ϳ��� �����ϼ��� : ");
		num = sc.nextInt();
		if(num == 0) {
			System.out.println("����� ����");
		}else if (num == 1) {
			System.out.println("����� ����");
		}else if(num == 2) {
			System.out.println("����� ��");
		}else {
			System.out.println("��ȿ���� ���� ���Դϴ�.");
		}
		sc.close();
	}
}
