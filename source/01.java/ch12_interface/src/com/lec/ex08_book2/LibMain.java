package com.lec.ex08_book2;

import java.util.Scanner;

public class LibMain {

	public static void main(String[] args) {
		BookLib[] books = {	new BookLib("890ㅁ-101-1ㄱ","java", "홍길동"),
							new BookLib("110ㄱ-111-1ㄱ","dbms","신길동"),
							new BookLib("770ㄱ-123-2ㅌ","web","고길동"),
							new BookLib("110ㄱ-123-2ㅌ","jsp","유길동"),
							new BookLib("110ㄱ-123-2ㄷ","spring","김길동")};
		Scanner scanner = new Scanner(System.in);
		int fn; 
		int idx; 
		String bTitle, borrower, checkOutDate; 
		do {
			System.out.print("1:대출 | 2:반납 | 3:책list | 0:종료");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: 
				System.out.print("대출할 책 이름 : ");
				bTitle = scanner.next(); 
				for(idx = 0 ; idx<books.length ; idx++) { 
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {
					if(books[idx].getState()==BookLib.STATE_BORROWED) { // 대출불가 상태
						System.out.println("현재 대출중인 도서입니다");
					}else { // 대출가능상태
						System.out.println("대출자는 : ");
						borrower = scanner.next();
						System.out.println("대출일은 : ");
						checkOutDate = scanner.next();
						books[idx].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 2: 
				System.out.print("반납할 책 이름 : ");
				bTitle = scanner.next(); 
				for(idx = 0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}// 책 조회 for
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {
					if(books[idx].getState()==BookLib.STATE_NORMAL) { 
						System.out.println("이미 반납된 도서입니다");
					}else { 
						books[idx].checkIn();
					}
				}
				break;
			case 3:
				System.out.println("책 리스트는 다음과 같습니다");
				for(BookLib book : books) {
					book.printState();
				}
				break;
			}
		}while(fn!=0);
		System.out.println("BYE");
		scanner.close();
	}

}
