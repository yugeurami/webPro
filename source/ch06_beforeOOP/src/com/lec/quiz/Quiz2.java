package com.lec.quiz;

import java.util.Scanner;

// ����ڷκ��� ���� �Է¹޾� ���밪�� ���(��, �Ű������� �޾� ���밪�� �����ϴ� �Լ� �̿�)
public class Quiz2 {

	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		su = sc.nextInt();
		System.out.printf("�� ���� ���밪�� %d�Դϴ�", abs(su));
		sc.close();
	}
	
	private static int abs(int su) {
		int result = su>=0 ? su : -su;
		return result;
	}

}
