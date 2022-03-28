package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lec.ex1_string.Friend;

public class EX06_FriendSimpleDateFormat {

	public static void main(String[] args) {
		Friend[] friends = {new Friend("홍길동", "010-9999-9999", "05-22"),
							new Friend("신길동", "010-8888-8888", "09-22"),
							new Friend("마길동", "010-8888-9999", "08-22"),
							new Friend("윤길동", "010-7777-7777", "04-22"),
							new Friend("김길동", "010-6666-7777", "03-28")};
		
		/* 검색할 전화번호 뒷자리를 입력받아				=> 시스템으로 부터 오늘의 날짜를 받아 "MM-dd" 스타일의 String으로 변환
		 * 0~끝방까지 해당 전화번호가 있으면 출력 		=> 0~끝방까지 오늘과 같은 날짜가 있으면 출력
		 * 검색이 되지 않아 출력 못하면 없는데라고 출력 	=> 해당 생일자가 없어 출력을 못하면 없는데라고 출력
		 */
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String now = sdf.format(date);
		boolean searchOk = false;
		for(Friend f : friends) {
			if(f.getBirth().equals(now)) {
				System.out.println("생일을 축하합니다");
				System.out.println(f);
				searchOk = true;
			}
		}
		if(!searchOk) {
			System.out.println("오늘 생일인 친구는 없습니다");
		}
	}

}
