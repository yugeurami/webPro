package com.lec.ex1_parentchild;

public class TestMain {
	public static void main(String[] args) {
		ChildClass child = new ChildClass();
		child.getMamiName();
		child.getPapaName();
		System.out.println(child.pStr);
		System.out.println(child.cStr);
	}
}
