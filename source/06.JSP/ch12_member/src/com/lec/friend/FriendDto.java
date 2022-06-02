package com.lec.friend;

public class FriendDto {
	private int fnum;
	private String name;
	private String phone;
	public FriendDto() {}
	public FriendDto(int fnum, String name, String phone) {
		this.fnum = fnum;
		this.name = name;
		this.phone = phone;
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "FriendDto [fnum=" + fnum + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
