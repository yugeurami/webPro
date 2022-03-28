package com.lec.ex1_string;

import java.util.Scanner;

// 전화번호 받아, 입력받은 전화번호, 짝수번째 문자, 꺼꾸로, 전화번호 앞자기, 전화번호 뒷자리
public class Ex06_telPrint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("전화번호를 입력하세요(010-0000-000형식, 단 종료는 X)");
			String tel = sc.next(); //스트링 입력
			if(tel.equalsIgnoreCase("x")) {
				break;
			}
			System.out.println("입력한 전화번호:"+tel);
			System.out.print("짝수번째 문자열 : ");
			for (int i = 0 ; i<tel.length() ; i++) {
				if(i%2 == 0) {
					System.out.print(tel.charAt(i)); // 짝수번째 문자 출력
				}else {
					System.out.print(' '); //홀수번째 문자열 대신 ' ' 출력
				}
			}
			System.out.println();
			System.out.print("문자를 꺼꾸로 : ");
			for(int i = tel.length()-1 ; i>=0 ; i--) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			int first = tel.indexOf('-');
			int last = tel.lastIndexOf('-');
			String pre = tel.substring(0,first);
			String mid = tel.substring(first+1,last-1);
			String post = tel.substring(last+1);
			System.out.println("전화번호 앞자리 : "+pre);
			System.out.println("전화번호 뒷자리 : "+post);
		}while(true);
		
	}
}
