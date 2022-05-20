package com.test2;

public class Staff extends Person {
	public static int num = 0;
	private String department;
	public Staff(String name, String department) {
		super(name);
		this.department = department;
		num++;
		super.setId("S0" + num);
	}
	@Override
	public String toString() {
		return super.toString() + "\t(부서)" + department;
	}
	
}
