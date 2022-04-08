package com.lec.ex02_protectedmember;

public class TestMain {

	public static void main(String[] args) {
		Child child = new Child(1, 2); // SuperIJ의 매개변수 없는 생성자 실행 후 Child의 매개변수 있는 생성자 실행
		System.out.println("child의 i : "+ child.getI());
		System.out.println("child의 j : "+child.getJ());
		child.setI(10);
		child.setJ(20);
		child.sum();
	}

}
