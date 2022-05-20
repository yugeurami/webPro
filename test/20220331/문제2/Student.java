package com.test2;

public class Student extends Person {
	public static int num = 0;
	private String subject;
	public Student(String name, String subject) {
		super(name);
		this.subject = subject;
		num++;
		super.setId("G0" + num);
	}
	@Override
	public String toString() {
		return super.toString() + "\t(과목)" + subject;
	}
	
}
