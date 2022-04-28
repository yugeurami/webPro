package com.lec.loop;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 수를 입력해주세요 : ");
		int num = sc.nextInt();
		if(0>num) {
			System.out.println("입력이 잘못됐습니다. 1~9까지의 숫자를 입력해주세요");
		} else if (num>9) {
			System.out.println("입력이 잘못됐습니다. 1~9까지의 숫자를 입력해주세요");
		} else {
			for ( int i = 1 ; i<10 ; i++) {
				System.out.printf("%d*%d=%d\n", num, i, num*i);
			}
		}
		sc.close();
	}
}
