package com.lec.ex6_wrapper;

import java.util.Scanner;

// 사용자로부터 정수 문자열(" 100 ")을 입력받아 정수로 수정해서 출력하는 프로그램
public class Ex04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		String numStr = sc.nextLine();
		System.out.println("입력하신 문자열은 "+numStr);
		numStr = numStr.trim(); // 좌우 space 제거
		numStr = numStr.replaceAll("\\D", ""); //문자제거
		int num = Integer.parseInt(numStr); // numStr에 정수만 들어있어야함
		System.out.println("변형된 정수는 "+num);
	}
}
