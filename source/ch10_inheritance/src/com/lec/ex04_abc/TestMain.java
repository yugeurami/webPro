package com.lec.ex04_abc;

public class TestMain {

	public static void main(String[] args) {
		S s = new S();
		//A a = new A();
		S a = new A(); //변수의 타입은 S 객체는 A
		//B b = new B();
		S b = new B();
		S c = new C();
		S[] arr = {s,a,b,c};
		for (S obj : arr) {
			System.out.println(obj.s);
		}
	}

}
