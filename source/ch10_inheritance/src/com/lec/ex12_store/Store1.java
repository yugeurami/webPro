package com.lec.ex12_store;
// 주택가에 매장1호점: 부대찌개-5,000  순대국-안팔아 
public class Store1 extends HeadQuarterStore {

	public Store1(String str) {
		super(str);
	}
	@Override
	public void bude() {
		System.out.println("부대찌개 - 5,000원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 안 팔아");
	}
}
