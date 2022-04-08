package com.lec.ex6_member;
//id, pw, name, email, address, birth, gender
/*
 * 메소드 : “아이디 = aaa
         이름 = 홍길동
         이메일 = hong@company.com
         주소 = 서울 강남구
         생일 = 2000-01-01
         성별 = 남 ”(객체 정보)을 return하는 infoString() 메소드

 */
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private String gender;
	
	public Member() {	}
	public Member(String id, String pw, String name, String email, String address, String birth, String gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	public String infoString() {
		return String.format("아이디 = %s\n이름 = %s\n이메일 = %s\n주소 = %s\n생일 = %s\n성별 = %s", id, name, email, address, birth, gender);
	}
	
}
