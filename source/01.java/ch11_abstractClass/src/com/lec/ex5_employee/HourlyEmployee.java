package com.lec.ex5_employee;

public class HourlyEmployee extends Employee {
	private int hoursWorked;
	private int moneyPerHour;
	
	public HourlyEmployee(String name, int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}

	@Override
	public void computePay() {
		System.out.println("~ ~ ~ 월급명세서 ~ ~ ~");
		System.out.println("이름 : "+getName());
		System.out.println("월급 : "+(hoursWorked*moneyPerHour)+"원");
		COMPUTEINCENSTIVE((hoursWorked*moneyPerHour));
	}

}
