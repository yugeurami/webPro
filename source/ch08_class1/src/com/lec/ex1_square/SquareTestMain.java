package com.lec.ex1_square;

public class SquareTestMain {
	
	public static void main(String[] args) {
		Square s1 = new Square();// new �ڿ� �ִ� �� ������ �Լ�
		System.out.println("s1�� �Ѻ��� ���� : "+s1.getSide());
		s1.setSide(5);
		System.out.println("s1�� ���� : "+s1.area());
		Square s2 = new Square(10);// side�� 10���� �ʱ�ȭ
		System.out.println("s2�� ���� : "+s2.area());
		s2.setSide(50);
		System.out.println("s2�� ���� : "+s2.area());
	}
}
