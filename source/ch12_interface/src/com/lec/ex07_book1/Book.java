package com.lec.ex07_book1;
// Book b = new Book("890ㅁ-101-1ㄱ","java", "홍길동")
public class Book implements ILendable {
	private String bookNo;			// 책번로 890ㅁ-101-1ㄱ
	private String bookTitle;		// 책제목
	private String writer; 			// 저자
	private String borrwer; 		// 대출인
	private String checkOutDate;	// 대출일
	private byte state;				// 대출중(1), 대출가능(0)
	
	
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { // 대출중이면 메세지 뿌리고 끝
			System.out.println(bookTitle+"도서는 대출중입니다");
			return;
		}
		// state가 0이라 대출처리 진행
		this.borrwer = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; // 대출중 상태로 전환
		System.out.println(borrower+"님,\n"+bookTitle+ "도서가 대출 처리되었습니다\n대출일 : "+checkOutDate);		
	}
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) { 
			System.out.println(bookTitle+"도서는 이미 반납됐습니다");
			return;
		}
		borrwer = null;
		checkOutDate = null;
		state = STATE_NORMAL; 
		System.out.println(bookTitle+"도서가 반납 완료되었습니다");
	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "지음)\t대출가능");
		} else if(state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "지음)\t대출중");
		} else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "지음)\t이상해");
		}
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + "지음)";
//		msg = msg + ((state == STATE_NORMAL) ? "대출가능" : (state == STATE_BORROWED) ? "대출중" : "이상해");
//		System.out.println(msg);		
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public byte getState() {
		return state;
	}
	
}
