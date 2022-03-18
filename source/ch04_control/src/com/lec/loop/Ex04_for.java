package com.lec.loop;
// 1~40까지 한줄에 4개씩
public class Ex04_for {

	public static void main(String[] args) {
		for (int i=1 ; i<=40 ; i++) {
			System.out.print(i+"\t");
			if (i%4 == 0) {
				System.out.println();//i가 4의 배수이면 개행
			}//if
		}//for
	}//main
}
