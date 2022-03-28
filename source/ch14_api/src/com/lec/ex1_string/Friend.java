package com.lec.ex1_string;

public class Friend {
	
	private String name;
	private String phone;
	private String birth;
	
	public Friend(String name, String phone, String birth) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "이름 : "+name+"\n전화번호 : "+phone+"\n생일 : "+birth;
	}
	public String getPhone() {
		return phone;
	}
	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	
}
