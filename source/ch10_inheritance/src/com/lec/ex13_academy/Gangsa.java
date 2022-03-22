package com.lec.ex13_academy;

public class Gangsa extends Person {
	private String subject;
	private static int count;

	public Gangsa(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		++count;
		setNo("lec"+count);
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(과목)"+subject);
	}
}
