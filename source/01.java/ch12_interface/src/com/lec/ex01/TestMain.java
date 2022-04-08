package com.lec.ex01;

public class TestMain extends InterfaceClass {

	public static void main(String[] args) {
//		InterfaceEx1 ex1 = new InterfaceEx1();  인터페이스 객체 생성불가
		InterfaceClass obj1 = new InterfaceClass();
		obj1.method1();
		obj1.method2();
		System.out.println(obj1.CONSTANT_NUM+"/"+obj1.CONSTANT_STRING); //객체변수로 static access 비추
		System.out.println(InterfaceEx1.CONSTANT_NUM+"/"+InterfaceEx2.CONSTANT_STRING);
		InterfaceEx1 obj2 = new InterfaceClass();
		obj2.method1();
		if(obj2 instanceof InterfaceClass) {
			((InterfaceClass)obj2).method2();
		}
		//System.out.println(obj2.CONSTANT_STRING);
		InterfaceEx2 obj3 = new InterfaceClass();
		//obj3.method1()
		obj3.method2();
	}
}