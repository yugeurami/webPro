package com.lec.ex08_book2;

import com.lec.ex07_book1.ILendable;

public class BookLib extends BookInfo implements ILendable {
	private String borrwer; 		
	private String checkOutDate;	
	private byte state;	
	
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		super(bookNo, bookTitle, writer);
	}
	
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(super.getBookTitle()+"도서는 대출중입니다");
			return;
		}
		// state가 0이라 대출처리 진행
		this.borrwer = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 대출중 상태로 전환
		System.out.println(borrower+"님,\t"+super.getBookTitle()+ "도서가 대출 처리되었습니다\n대출일 : "+checkOutDate);		
	}
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) { 
			System.out.println(super.getBookTitle()+"도서는 이미 반납됐습니다");
			return;
		}
		borrwer = null;
		checkOutDate = null;
		state = STATE_NORMAL; 
		System.out.println(super.getBookTitle()+"도서가 반납 완료되었습니다");
	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + "지음)\t대출가능");
		} else if(state == STATE_BORROWED) {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + "지음)\t대출중");
		} else {
			System.out.println(super.getBookNo() + "\t" + super.getBookTitle() + "(" + super.getWriter() + "지음)\t이상해");
		}
	}

	public byte getState() {
		return state;
	}
	
}
