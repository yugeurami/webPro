package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		Book[] books = {	new Book("890ㅁ-101-1ㄱ","java", "홍길동"),
							new Book("110ㄱ-111-1ㄱ","dbms","신길동"),
							new Book("770ㄱ-123-2ㅌ","web","고길동"),
							new Book("110ㄱ-123-2ㅌ","jsp","유길동"),
							new Book("110ㄱ-123-2ㄷ","spring","김길동")};
		Scanner scanner = new Scanner(System.in);
		int fn; // 기능번호(1: 대출 | 2:반납 | 3:책list | 0:종료)
		int idx; // 대출하거나 반납하려고 할 때 조회된 책의 index
		String bTitle, borrower, checkOutDate; // 사용자에게 받을 책이름, 대출인, 대출일
		do {
			System.out.print("1:대출 | 2:반납 | 3:책list | 0:종료");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: 
				// 대출처리 1.책이름입력 2.책조회 3.책상태확인 4.대출인입력 5.대출일입력 6.대출메소드 호출
				System.out.print("대출할 책 이름 : ");
				bTitle = scanner.next(); // white-space 앞까지의 스트링만 받음
				for(idx = 0 ; idx<books.length ; idx++) { // 이런 경우 확장 for문보다 일반 for문이 나음
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}// 책 조회 for
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {
					if(books[idx].getState()==Book.STATE_BORROWED) { // 대출불가 상태
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
				// 반납처리 1.책이름입력 2.책조회 3.책상태확인 4.반납 메소드 호출
				System.out.print("반납할 책 이름 : ");
				bTitle = scanner.next(); // white-space 앞까지의 스트링만 받음
				for(idx = 0 ; idx<books.length ; idx++) {
					if(books[idx].getBookTitle().equals(bTitle)) {
						break;
					}
				}// 책 조회 for
				if(idx == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {
					if(books[idx].getState()==Book.STATE_NORMAL) { 
						System.out.println("이미 반납된 도서입니다");
					}else { 
						books[idx].checkIn();
					}
				}
				break;
			case 3:
				System.out.println("책 리스트는 다음과 같습니다");
				for(Book book : books) {
					book.printState();
				}
				break;
			}
		}while(fn!=0);
		System.out.println("BYE");
		
//		while(true){
//			System.out.print("1:대출 | 2:반납 | 3:책list | 0:종료");
//			fn = scanner.nextInt();
//			if(fn==0) {
//				break;
//			}
//		}
	}

}
