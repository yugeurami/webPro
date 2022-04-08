package com.lec.ex5_lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {
	private String 	bookNo;			//책번호
	private String	bookTitle;		//책이름
	private String 	writer;			//저자
	private String 	borrower;		//대출인
	private Date	checkOutDate;	//대출일
	private byte	state;			//대출 중(1), 대출가능(0)
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	@Override
	public void checkOut(String borrower) throws Exception {
		if(state == STATE_BORROWED) {
			throw new Exception(bookTitle + "도서는 대출중입니다");
		}
		this.borrower = borrower;
		checkOutDate = new Date();
		state = STATE_BORROWED;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d(E)");
		System.out.println("\""+bookTitle+"\" 도서가 대출되었습니다");
		System.out.println("대출인 : "+borrower+ " / 대출일 : "+sdf.format(checkOutDate) + "2주내로 반납하세요");
		
	} 
	//book.checkIn() : 도서상태 확인 ->연체여부 확인 ->(if. 연체되었을 경우 연체료 납부 y/n) -> 반납로직 -> 도서상태출력
	@Override
	public void checkIn() throws Exception {
		if(state == STATE_NAMAL) {
			throw new Exception(bookTitle + "도서는 대출중이 아니예요");
		}
		//연체여부 확인 checkOutDate ~현재까지 14일 이내인지 여부
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime(); //대출시점부터 현재까지의 밀리세컨
		long day = diff/(1000*60*60*24);
		if(day>14) {// 연체된 경우
			System.out.println("연체료는 일일 100원 부가됩니다. 내셔야할 연체료는 "+(day-14)*100+"원입니다");
			Scanner scanner = new Scanner(System.in);
			System.out.println("연체료를 내셨나요? (Y/N)");
			if(! scanner.next().equalsIgnoreCase("y")) { // 연체료를 냈다고 y를 입력하지 않은 경우
				System.out.println("연체료를 내셔야 반납처리가 가능합니다. 연체료를 내세요");
				return;
			}
		}
		// 반납로직
		borrower = null;
		checkOutDate = null;
		state = STATE_NAMAL;
		System.out.println("\""+bookTitle+"\" 도서가 반납되었습니다");
	}

	@Override
	public String toString() {
		String msg = "책번호 : "+bookNo+"\t책이름 : "+bookTitle+"\t저자 : "+writer;
		msg += (state == STATE_NAMAL) ? "\t대출가능" : "\t대출중";
		if(state == STATE_BORROWED) {
			//빌린 시점 + 14일
			Date date = new Date(checkOutDate.getTime() + (1000*60*60*24*14));
			SimpleDateFormat sdf = new SimpleDateFormat("\t반납예정일 : yyyy-M-d(E)");
			msg += sdf.format(date);
		}
		return msg;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
}
