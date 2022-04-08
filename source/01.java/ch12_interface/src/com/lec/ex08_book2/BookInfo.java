package com.lec.ex08_book2;

public class BookInfo {
	private String bookNo;			
	private String bookTitle;		
	private String writer;
	

	public BookInfo(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public String getBookNo() {
		return bookNo;
	}


	public String getWriter() {
		return writer;
	}
	
}
