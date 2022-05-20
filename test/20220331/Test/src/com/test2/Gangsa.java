package com.test2;

public class Gangsa extends Person {
	public static int num = 0;
	private String ban;
	public Gangsa(String name, String ban) {
		super(name);
		this.ban = ban;
		num++;
		super.setId("A0" + num);
	}
	@Override
	public String toString() {
		return super.toString() + "\t(반)" + ban;
	}
	
}
