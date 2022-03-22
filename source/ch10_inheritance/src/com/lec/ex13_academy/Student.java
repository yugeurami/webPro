package com.lec.ex13_academy;

public class Student extends Person {
	private String ban;
	private static int count;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		++count;
		setNo("st10"+count);
	}
	
	@Override
	public void print() {
		super.print();
		System.out.println("\t(반)"+ban);
	}
}
