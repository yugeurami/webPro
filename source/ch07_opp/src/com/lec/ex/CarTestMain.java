package com.lec.ex;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("red"); //yourPorsche���� ������ ���� ����
		System.out.println(myPorsche.getColor()+", "+"��ⷮ"+myPorsche.getCc()+", �ӵ�:"+myPorsche.getSpeed());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.getSpeed());
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		yourPorsche.drive();
	}
}

