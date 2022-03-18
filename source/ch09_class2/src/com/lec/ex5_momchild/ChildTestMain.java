package com.lec.ex5_momchild;

public class ChildTestMain {

	public static void main(String[] args) {
		Child child1 = new Child("첫째 똘만이");
		Child child2 = new Child("둘때 갑돌이");
		Child child3 = new Child("셋째 똘순이");
		child1.takeMoney(1000);
		child2.takeMoney(1000);
		child3.takeMoney(1000);
		System.out.println(Child.momPouch.money); // 클래스 이름을 통해서 엑세스
		System.out.println(child1.momPouch.money); //static은 객체 이름으로 엑세스 하면 워닝뜸
		System.out.println(child2.momPouch.money);
		System.out.println(child3.momPouch.money);
	}

}
