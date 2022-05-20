package com.test;

public class Person {
	private String name;
	private String tel;
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "이름 " + name + ", 전화번호 " + tel;
	}
	
	
	
}
