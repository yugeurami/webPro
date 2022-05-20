package com.test2;

public class Person {
	private String id;
	private String name;
	public Person(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "(ID)"+ id + "\t(이름)" + name;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
