package com.lec.ex1_store;

public abstract class HeadQuarterStore {
	private String str; // "본사"
	public HeadQuarterStore(String str) {
		this.str = str;
	}
	public abstract void kimchi(); // 메소드 구현은 없고 선언만 되어 있는 메소드 : 추상메소드
	//클래스 내 추상 메소드가 하나 이상일 때 : 추상클래스
	public abstract void bude();
	public abstract void bibim();
	public abstract void sunde();
	public abstract void gonggibab();
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
