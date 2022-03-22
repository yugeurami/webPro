package com.lec.ex2;
// method1(추상메소드), method2(일반 메소드) : 추상메소드는 사용하기 위해서는 무조건 오버라이드해야함
public class ChildClass extends SuperClass {

	@Override
	public void method1() {
		System.out.println("ChildClass의 method1 - 추상메소드라서 오버라이드 함");
	}
	@Override
	public void method2() {
		System.out.println("ChildClass의 method2 - 그냥 오버라이드 함");
	}
}
