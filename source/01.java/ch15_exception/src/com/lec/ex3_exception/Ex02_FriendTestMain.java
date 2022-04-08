package com.lec.ex3_exception;

import java.util.Date;

public class Ex02_FriendTestMain {

	public static void main(String[] args) {
		Friend hong = new Friend("홍길동", "010-1234-0703");
		hong.setEnterDate(new Date(122,2,11));
		System.out.println(hong);
		Friend kim = new Friend("김길동");
		System.out.println(kim);
	}

}
