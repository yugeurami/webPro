package com.lec.ex1_string;

import java.util.Scanner;

public class Ex08_TestMain {
	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "05-22"),
							new Friend("신길동", "010-8888-8888", "09-22"),
							new Friend("마길동", "010-8888-9999", "08-22"),
							new Friend("윤길동", "010-7777-7777", "04-22"),
							new Friend("김길동", "010-6666-7777", "03-22")};
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("찾으시려는 분의 전화번호 뒷자리를 입력해주세요 : ");
			String lastPh = scanner.next();
			if(lastPh.equalsIgnoreCase("x")) {
				break;
			}
			boolean searchOk = false;
			for(int i = 0 ; i<friends.length ; i++) {
				String tel = friends[i].getPhone();
				String lastTel = tel.substring(tel.lastIndexOf('-')+1);
				if((lastTel).equals(lastPh)) {
					System.out.println(friends[i]);
					searchOk = true;
				}
			}
			if(searchOk==false) { 
				System.out.println("검색하신 전화번호가 없습니다.");
			}
		} while(true); 
		System.out.println("종료합니다");
		scanner.close();
	}
}
