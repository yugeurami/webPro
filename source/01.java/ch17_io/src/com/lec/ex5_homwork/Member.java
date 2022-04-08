package com.lec.ex5_homwork;

public class Member {
	private String name;
	private String phone;
	private String birth;
	private String address;
	
	public Member() {	}

	public Member(String name, String phone, String birth, String address) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
		this.address = address;
	}
	@Override
	public String toString() {
		return name+"\t"+phone+"\t"+birth.substring(5)+"생 \t"+address+"\n";
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}
	
	
}
