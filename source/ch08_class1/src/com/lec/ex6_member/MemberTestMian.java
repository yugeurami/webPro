package com.lec.ex6_member;

public class MemberTestMian {

	public static void main(String[] args) {
		Member name = new Member("aaa", "000", "홍길동", "hong@company.com", "서울 강남구", "2000-01-01", "남");
		System.out.println(name.infoString());
	}
}


