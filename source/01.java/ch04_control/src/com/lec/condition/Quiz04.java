package com.lec.condition;

import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2) 중 하나를 선택하세요 : ");
		num = sc.nextInt();
		if(num == 0) {
			System.out.println("당신은 가위");
		}else if (num == 1) {
			System.out.println("당신은 바위");
		}else if(num == 2) {
			System.out.println("당신은 보");
		}else {
			System.out.println("유효하지 않은 값입니다.");
		}
		sc.close();
	}
}
