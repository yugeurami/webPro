package com.lec.ex2;
//method1(추상메소드), method2(일반 메소드)
public abstract class ChildClass2 extends SuperClass {
	@Override
	public void method2() {
		System.out.println("ChildClass2의 method2 - 그냥 오버라이드 함");
	}
}
