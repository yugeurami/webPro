package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03_scannerClose {

	public static void main(String[] args) {
		Scanner scMain = new Scanner(System.in);
		System.out.print("이름은 ");
		String name = scMain.nextLine();
		System.out.println("입력하신 이름은 "+name);
		nickName();
		System.out.print("나이는 ");
		int age = scMain.nextInt();
		System.out.println("입력하신 나이는 "+age);
	}
	private static void nickName() { //사용자로부터 별명을 받아 출력하는 메소드
		Scanner scNickName = new Scanner(System.in);
		System.out.print("별명은 ");
		System.out.println("입력하신 별명은 "+ scNickName.nextLine());
//		scNickName.close(); 여기서 buffer를 닫아버리면 밑에 실행이 안됨
		//Scanner close는 Main에서만 한다
	}
}
