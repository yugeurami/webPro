package com.lec.homework;

import java.util.Scanner;

public class homework1 {

	public static void main(String[] args) {
		int dansu;
		Scanner su = new Scanner(System.in);
		do {
			System.out.print("2~9사이의 수를 입력해주세요 : ");
			dansu = su.nextInt();
		} while(2>=dansu || dansu>=9);
		gugudan(dansu);
		su.close();
	}
	
	private static void gugudan(int dansu) {
		for(int i = 1 ; i<10 ; i++)
		System.out.printf("%d * %d = %d\n", dansu, i, dansu*i);
	}
}
