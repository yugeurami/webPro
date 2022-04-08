package com.lec.ex1_string;
// String 수정 > StringBuffer 수정 > StringBuilder 수정
public class Ex11_speedCheck {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis()); // 1970년 1월 1일부터 지금까지의 밀리세컨
		// 스트링 변경(10만번) - 시간체크
		String str = "A";
		long startTime = System.currentTimeMillis(); //로직 시작시점
		for(int i = 0 ; i<150000 ; i++) { //10만번 수정
			str = str + "a";
		}
		long endTime = System.currentTimeMillis();//로직 끝나는 시점
		System.out.println("String 10만번 수정 경과 시간 : "+(endTime-startTime));
		// StringBuffer 변경(10만번) - 시간체크
		StringBuffer strBuf = new StringBuffer("A");
		startTime = System.currentTimeMillis(); //로직 시작시점
		for(int i = 0 ; i<150000 ; i++) { //10만번 수정
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();//로직 끝나는 시점
		System.out.println("String 10만번 수정 경과 시간 : "+(endTime-startTime));
		
		// StringBuilder 변경(10만번) - 시간체크
		StringBuilder strBuld = new StringBuilder("A");
		startTime = System.currentTimeMillis(); //로직 시작시점
		for(int i = 0 ; i<150000 ; i++) { //10만번 수정
			strBuld.append("a");
		}
		endTime = System.currentTimeMillis();//로직 끝나는 시점
		System.out.println("String 10만번 수정 경과 시간 : "+(endTime-startTime));
	}
}
