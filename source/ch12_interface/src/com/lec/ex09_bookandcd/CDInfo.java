package com.lec.ex09_bookandcd;

public class CDInfo {
	private String CDNo;			
	private String CDTitle;		
	private String bookNo;

	

	public CDInfo(String cDNo, String cDTitle, String bookNo) {
		CDNo = cDNo;
		CDTitle = cDTitle;
		this.bookNo = bookNo;
	}


	public String getCDTitle() {
		return CDTitle;
	}


	public String getCDNo() {
		return CDNo;
	}


	public String getBookNo() {
		return bookNo;
	}

	
}
