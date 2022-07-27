package com.test.dto;

public class MoneyDto {
	private String pcode;
	private int allprice;
	
	public MoneyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MoneyDto(String pcode, int allprice) {
		this.pcode = pcode;
		this.allprice = allprice;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public int getAllprice() {
		return allprice;
	}

	public void setAllprice(int allprice) {
		this.allprice = allprice;
	}
	
	
}
