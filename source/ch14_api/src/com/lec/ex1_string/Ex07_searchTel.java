package com.lec.ex1_string;

import java.util.Scanner;

//배열에 있는 전화번호를 찾아 전체 전화번호 출력
public class Ex07_searchTel {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999", "02-888-8888", "010-7777-8888"};
		Scanner sc = new Scanner(System.in);
		String searchTel; //사용자로부터 전화번호 뒷번호 입력받은 데이터 할당
		boolean searchOk = false;
		System.out.print("검색하고자 하는 회원의 전화번호 뒷자리는 : ");
		searchTel = sc.next();
		for(int idx = 0 ; idx<tels.length ; idx++) {
			String post = tels[idx].substring(tels[idx].lastIndexOf('-')+1);
			if(post.equals(searchTel)) {
				System.out.println("검색하신 전화번호는 "+tels[idx]+"입니다.");
				searchOk = true;
			}//전화번호를 찾을 경우 더이상 검색하지 않고 for문 빠져나감
		}
		if(! searchOk) { //searchTel이 배열 전화에 없어서 못찾고 idx가 끝까지 간 경
			System.out.println("검색하신 전화번호가 없습니다.");
		}
		sc.close();
	}
}
