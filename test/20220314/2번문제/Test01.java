package com.lec.loop;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���� �Է����ּ��� : ");
		int num = sc.nextInt();
		if(0>num) {
			System.out.println("�Է��� �߸��ƽ��ϴ�. 1~9������ ���ڸ� �Է����ּ���");
		} else if (num>9) {
			System.out.println("�Է��� �߸��ƽ��ϴ�. 1~9������ ���ڸ� �Է����ּ���");
		} else {
			for ( int i = 1 ; i<10 ; i++) {
				System.out.printf("%d*%d=%d\n", num, i, num*i);
			}
		}
		sc.close();
	}
}
