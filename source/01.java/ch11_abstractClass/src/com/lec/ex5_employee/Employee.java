package com.lec.ex5_employee;

public abstract class Employee {
	private String name;
	public abstract void computePay();
	public final void COMPUTEINCENSTIVE(int pay) {
		if(pay>=2000000) {
			int incentive = pay/10;
			System.out.println("상여금 : "+incentive+"원");
		}
		
	}
	public Employee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
}
