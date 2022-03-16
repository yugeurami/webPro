package com.lec.ex;

public class CarTestMain {
	public static void main(String[] args) {
		Car myPorsche = new Car();
		myPorsche.setColor("red"); //yourPorsche에는 영향을 주지 않음
		System.out.println(myPorsche.getColor()+", "+"배기량"+myPorsche.getCc()+", 속도:"+myPorsche.getSpeed());
		myPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		System.out.println(myPorsche.getSpeed());
		
		Car yourPorsche = new Car();
		yourPorsche.setColor("gray");
		yourPorsche.drive();
	}
}

