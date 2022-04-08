package com.lec.ex1_string;

public class Ex05_regex {
	public static void main(String[] args) {
		String str = "010-9999-9999 aaaa4696@naver.com (02)000-0000, 반갑습니다. Hello 970906-2162925";
		System.out.println("replace =>"+ str.replace("0", "홍")); //0만 홍으로 바뀜
		/* 정규표현식 (regex)
		 * 1. 참조: https://goo.gl/HLntbd
		 * 
		 * 2. 간략문법
		 * 		\d(숫자와 매치, [0-9]와 동일) \D(숫자가 아닌것)
		 * 		\s(whitespace : space, 탭, 엔터)
		 * 		\w(영문자나 숫자, [a-zA-Z0-9]와 동일) \W(영문자나 숫자가 아닌 문자)
		 * 		.(문자하나)
		 * 		+(1번이상)
		 * 		*(0번 이상 반복)
		 * 		?(0~1번이상 반복)
		 * 		{2,4}(2~4회 반복)
		 * 
		 * 3. 정규표현식 연습장 :https://regexr.com/
		 * ex. 전화번호: [(]?[0-9]{2,3}.[0-9]{3,4}-[0-9]{4}
		 * 
		 * 4. 특정 정규표현식의 문자열 변경 : replaceAll("정규표현식", "대체문자열")
		 */
		// 전화번호 지움
		System.out.println(str.replaceAll("[(]?[0-9]{2,3}\\D[0-9]{3,4}-[0-9]{4}", "** 전화번호 지움 **"));
		//이메일 지움
		System.out.println(str.replaceAll("\\w+(@)\\w+(.)?\\w+(.)?\\w+", "이메일"));
		//알파벳 대신 *로 대체
		System.out.println(str.replaceAll("[a-zA-Z]", "*"));
		//한글 싹 다 없애
		System.out.println(str.replace("[가-힣ㄱ-ㅎ]", ""));
		//주민번호 뒷자리를 *로	
		System.out.println(str.replaceAll("[0-9]{7}", "*******"));
		
	}
}
