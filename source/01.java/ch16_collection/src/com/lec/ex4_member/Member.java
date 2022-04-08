package com.lec.ex4_member;

public class Member {
	private String name;
	private String tel;
	private String address;
	
	public Member() {
	}

	public Member(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	@Override
	public String toString() {
		return name +"\t"+ tel +"\t"+ address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}
	
}
