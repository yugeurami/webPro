package com.lec.ex;
/* ■■■■■■■■■■■■■■■
 * Hello, World!
 * ------------- printLine()
 * Hello, Java!
 * ~~~~~~~~~~~~~ printLine('~')
 * Hello, Hong!
 * ■■■■■■■■■■■■■■■
 */

public class Ex05_line {
	public static void main(String[] args) {
		printLine('■',40);
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, Hong!");
		printLine('■',40);
	}
	private static void printLine(int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print('-');
		}
		System.out.println(); // 매개변수로 받은 숫자만큼 '-'출력
	}
	
	private static void printLine(char c, int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println(); // 매개변수로 받은 숫자만큼 매개변수로 받은 문자 출력
	}
	
	private static void printLine(char c) {
		for(int i = 0 ; i<30 ; i++) {
			System.out.print(c);
		}
		System.out.println(); // 매개변수로 받은 c문자 30개 출력하고 개행
	}
	private static void printLine() { // return타입이 없고 매개변수가 없는 메소드(함수)
		for(int i = 0 ; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); //얇은 '-'20개 출력하고 개행
	}
}
