package com.lec.ex2_human;
//Man kim - new Man(22, 160 , 50.5, 010-0000-0000)
//Man kim - new Man(22, 160 , 50.5)
//Man kim - new Man(22)
public class Man {
	private int age;
	private int height;
	private double weight;
	private String phoneNum;
	public Man() {} // ����Ʈ ������ �Լ�
	public Man(int age) {
			this.age = age;
	}
//	public Man(int height) { ���� Ÿ���̱� ������ ������ �ȵ�
//		this.height = height;
//	}
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("�Ķ���Ͱ� 3��¥�� ������ �Լ� ȣ��");
	}
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("�Ķ���Ͱ� 4��¥�� ������ �Լ� ȣ��");
	}
}
