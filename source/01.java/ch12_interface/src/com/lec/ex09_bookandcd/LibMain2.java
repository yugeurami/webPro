package com.lec.ex09_bookandcd;

import java.util.Scanner;

public class LibMain2 {

	public static void main(String[] args) {
		BookLib[] books = {	new BookLib("890ㅁ-101-1ㄱ","java", "홍길동"),
							new BookLib("110ㄱ-111-1ㄱ","dbms","신길동"),
							new BookLib("770ㄱ-123-2ㅌ","web","고길동"),
							new BookLib("110ㄱ-123-2ㅌ","jsp","유길동"),
							new BookLib("110ㄱ-123-2ㄷ","spring","김길동")};
		CDLib[] cds = {	new CDLib("8954235","javacd", "890ㅁ-101-1ㄱ"),
						new CDLib("4587412","라푼젤",null),
						new CDLib("8545651","webcd","770ㄱ-123-2ㅌ"),
						new CDLib("5487237","jspcd","110ㄱ-123-2ㅌ"),
						new CDLib("2546216","springcd","110ㄱ-123-2ㄷ")};
		
		Scanner scanner = new Scanner(System.in);
		int fn; 
		int idxBook;
		int idxCD;
		String bTitle, cdTitle, borrower, checkOutDate; 
		do {
			System.out.print("1:책 대출 | 2:책 반납 | 3:CD 대출 | 4:CD 반납  | 5:리스트 출력 | 0:종료");
			fn = scanner.nextInt();
			switch(fn) {
			case 1: 
				System.out.print("대출할 책 이름 : ");
				bTitle = scanner.next(); 
				for(idxBook = 0 ; idxBook<books.length ; idxBook++) { 
					if(books[idxBook].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if(idxBook == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {
					if(books[idxBook].getState()==BookLib.STATE_BORROWED) { // 대출불가 상태
						System.out.println("현재 대출중인 도서입니다");
					}else { // 대출가능상태
						for(idxCD = 0 ; idxCD<cds.length ; idxCD++ ) {
							if(books[idxBook].getBookNo().equals(cds[idxCD].getBookNo())) {
								break;
							}
						}
						if(idxCD == cds.length) {
							System.out.println("대출자는 : ");
							borrower = scanner.next();
							System.out.println("대출일은 : ");
							checkOutDate = scanner.next();
							books[idxBook].checkOut(borrower, checkOutDate);
						}else {
							System.out.println("CD가 있는데 같이 빌리실래요?(빌리실 거면 0을 입력해주세요) :");
							int answer = scanner.nextInt();
							System.out.println("대출자는 : ");
							borrower = scanner.next();
							System.out.println("대출일은 : ");
							checkOutDate = scanner.next();
							books[idxBook].checkOut(borrower, checkOutDate);
							if(answer==0) {
								cds[idxCD].checkOut(borrower, checkOutDate);
							}
						}
					}
				}
				break;
			case 2: 
				System.out.print("반납할 책 이름 : ");
				bTitle = scanner.next(); 
				for(idxBook = 0 ; idxBook<books.length ; idxBook++) {
					if(books[idxBook].getBookTitle().equals(bTitle)) {
						break;
					}
				}
				if(idxBook == books.length) {
					System.out.println("해당 도서는 본 도서관의 책이 아닙니다");
				}else {
					if(books[idxBook].getState()==BookLib.STATE_NORMAL) { 
						System.out.println("이미 반납된 도서입니다");
					}else { 
						books[idxBook].checkIn();
					}
				}
				break;
			case 3:	
				System.out.print("대출하실 CD의 이름은 : ");
				cdTitle = scanner.next(); 
				for(idxCD = 0 ; idxCD<cds.length ; idxCD++) {
					if(cds[idxCD].getCDTitle().equals(cdTitle)) {
						break;
					}
				}
				if(idxCD == cds.length) {
					System.out.println("해당 CD는 본 도서관의 책이 아닙니다");
				}else {
					if(cds[idxCD].getState()==CDLib.STATE_BORROWED) { 
						System.out.println("대출 중인 CD입니다");
					}else { 
						System.out.println("대출자는 : ");
						borrower = scanner.next();
						System.out.println("대출일은 : ");
						checkOutDate = scanner.next();
						cds[idxCD].checkOut(borrower, checkOutDate);
					}
				}
				break;
			case 4:
				System.out.print("반납하실 CD의 이름은 : ");
				cdTitle = scanner.next(); 
				for(idxCD = 0 ; idxCD<cds.length ; idxCD++) {
					if(cds[idxCD].getCDTitle().equals(cdTitle)) {
						break;
					}
				}
				if(idxCD == cds.length) {
					System.out.println("해당 CD는 본 도서관의 책이 아닙니다");
				}else {
					if(cds[idxCD].getState()==CDLib.STATE_NORMAL) { 
						System.out.println("이미 반납된 CD입니다");
					}else { 
						cds[idxCD].checkIn();
					}
				}
				break;
			case 5:
				System.out.println("리스트는 다음과 같습니다");
				for(BookLib book : books) {
					book.printState();
				}
				System.out.println("---------------------------");
				for(CDLib cd : cds) {
					cd.printState();
				}
				break;
			}
		}while(fn!=0);
		System.out.println("BYE");
		scanner.close();
	}

}
