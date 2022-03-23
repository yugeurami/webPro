package com.lec.ex5_employee;

public class SalaryEmployee extends Employee {
	private int annalSalary;
	
	public SalaryEmployee(String name, int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}

	@Override
	public void computePay() {
		System.out.println("~ ~ ~ 월급명세서 ~ ~ ~");
		System.out.println("이름 : "+getName());
		System.out.println("월급 : "+annalSalary/14+"원");
		COMPUTEINCENSTIVE(annalSalary/14);
	}
	
}
