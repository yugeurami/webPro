package com.lec.ex12_store;
//증권가에 매장3호점: 김치찌개-6,000  부대찌개-7,000  비빔밥-7,000 순대국-6,000  공기밥-1,000원
public class Store3 extends HeadQuarterStore {

	public Store3(String str) {
		super(str);
	}
	@Override
	public void kimchi() {
		System.out.println("김치찌개 - 6,000원");
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 - 7,000원");
	}
	@Override
	public void bibim() {
		System.out.println("비빔밥 - 7,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 - 6,000원");
	}
}
