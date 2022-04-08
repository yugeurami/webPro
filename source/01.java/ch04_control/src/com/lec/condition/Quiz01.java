package com.lec.condition;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력해주세요 : ");
		num = sc.nextInt();
		if (num > 0) {
			System.out.println("절대값은 :"+ num);
		}else {
			System.out.println("절대값은 :"+ -num);
		}
		sc.close();

	}

}
