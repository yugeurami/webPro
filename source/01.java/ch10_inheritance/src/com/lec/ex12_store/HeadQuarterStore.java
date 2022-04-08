package com.lec.ex12_store;
// 본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public class HeadQuarterStore {
	private String str; // "본사"
	public HeadQuarterStore(String str) {
		this.str = str;
	}
	public void kimchi() {
		System.out.println("김치찌개 - 5,000원");
	}
	public void bude() {
		System.out.println("부대찌개 - 6,000원");
	}
	public void bibim() {
		System.out.println("비빔밥 - 6,000원");
	}
	public void sunde() {
		System.out.println("순대국 - 5,000원");
	}
	public void gonggibab() {
		System.out.println("공기밥 - 1,000원");
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
