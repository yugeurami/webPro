package com.lec.ex;
// class : ������(�Ӽ�, �ν��Ͻ�����)�� �޼ҵ�(���, setter, getter)
// Car c = new Car()
// c.park()
public class Car {
	private String 	color; 	// ����
	private int 	cc; 	// ��ⷮ
	private int 	speed; 	// �ӵ�
	public void drive() {
		speed = 60;
		System.out.println(color+"�� ���� �����Ѵ�. ���� �ӵ� : "+speed);
	}
	public void park() {
		speed = 0;
		System.out.println(color+"�� ���� �����Ѵ�. ���� �ӵ� : "+speed);
	}
	public void race() {
		speed = 120;
		System.out.println(color+"�� ���� �����Ѵ�. ���� �ӵ� : "+speed);
	}
	
	//setter & getter (color, cc, speed)
	//myPorsche.color = "red"
	//=> myPorsche.methodName("red")
	public void setColor(String color) {
		this.color = color; //this = �� ��ü�� ����
	}
	
	public void setCc(int cc) {
		this.cc = cc;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	// myPorsche.getColor()
	public String getColor() {
		return color;
	}
	public int getCc() {
		return cc;
	}
	public int getSpeed() {
		return speed;
	}
	
}
