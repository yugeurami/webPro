package com.lec.ex1_store;
// 2호점: 김치찌개-5,000 부대찌개-5,000 비빔밥-5,000 순대국-5,000  공기밥-무료
public class Store2 extends HeadQuarterStore {

	
	public Store2(String str) {
		super(str);
	}
	
	@Override
	public void bude() {
		System.out.println("부대찌개 - 5,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 - 5,000원");
	}
	@Override
	public void gonggibab() {
		System.out.println("공기밥 - 무료");
	}

	@Override
	public void kimchi() {
		System.out.println("김치찌개 - 4,500원");
	}

	@Override
	public void sunde() {
		System.out.println("순대국 - 5,000원");
	}
}
