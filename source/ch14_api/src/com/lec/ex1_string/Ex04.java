package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String no;
		System.out.println("주민번호를 입력해주세요");
		no = scanner.next();
		char gender = no.charAt(7);
		if(gender == '2' || gender =='4') {
			System.out.println("여자");
		}else if(gender == '1' || gender == '3') {
			System.out.println("남자");
		}else {
			System.out.println("잘못입력하셨습니다");
		}
		       
	}

}
