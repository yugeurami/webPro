package com.lec.ex13_academy;

public class Staff extends Person {
	private String department;
	private static int count;
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		++count;
		setNo("staff"+count);
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t(부서)"+department);
	}
	
	
	
}
