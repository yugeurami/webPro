package com.lec.ex7_product;

public class ProductTestMain {

	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product();
		p1.infoPrint();
		p2.infoPrint();
		System.out.println("static 변수 = 클래스 변수 = 공유변수(일명 깍두기) count : " + Product.count);

	}

}
