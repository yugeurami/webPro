package com.lec.loop;
//break : 블럭을 완전히 빠져나감
//continue : 블럭의 실행을 멈추고 증감부분으로 감
public class Ex05_breakContinue {

	public static void main(String[] args) {
		for( int i = 0 ; i<=5 ; i++ ) {
			if(i==3) {
				//break; 반복문 블럭 빠져 나가기
				continue;
			}
			System.out.println(i+". 안녕");
		}

	}

}
