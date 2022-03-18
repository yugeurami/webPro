package com.lec.loop;

import java.util.Scanner;
//짝수를 입력받는 프로그램
public class Ex08_do_while {

	public static void main(String[] args) {
		int num;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("짝수를 입력하세요 : ");
			num = scanner.nextInt();
		}while(num%2 != 0);
		
		System.out.println("입력하신 수는 짝수 "+num+"입니다");
		
		scanner.close();
	}

}
