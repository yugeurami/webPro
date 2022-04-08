package com.lec.ex06_override;

public class TestMain {
	public static void main(String[] args) {
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(1);
		if(pObj1.equals(pObj2)) {
			System.out.println("두 객체는 같다");
		}else {
			System.out.println("두 객체는 다르다");
		}
		ChildClass cObj = new ChildClass(2);
		if(cObj.equals(pObj2)) { // 둘의 순서가 바뀌면 ParentClass의 equals로(= Object 클래스의 equals)
			System.out.println("무조건 true지");
		}
		pObj1.method1();
		pObj2.method2();
		System.out.println("--------------------------------");
		cObj.method1(); // ChildClass의 method1
		cObj.method2(); // ParentClass의 method2
		cObj.method3(); // ChildClass의 method3
		
		ParentClass cObj1 = new ChildClass(2);
		cObj1.method1(); // ChildClass의 method1
		cObj1.method2(); // ParentClass의 method2
		//ParentClass형 cObj1변수 ChildClass형으로 변환 가능하니?
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3(); // ChildClass의 method3
		} // if
	} //main
} // class
