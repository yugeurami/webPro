package com.lec.ex3_exception;

import java.text.SimpleDateFormat;
import java.util.Date;

// Friend f = new Friend("홍길동", "010-0000-0000")
// System.out.print(f) => [이름]홍길동 [전화]***-****-0000 [입력일]22년4월1일

public class Friend {
	private String name;
	private String tel;
	private Date enterDate;
	public Friend(String name) {
		this.name = name;
		enterDate = new Date();
	}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
		enterDate = new Date();
	}
	@Override
	public String toString() { // [이름]홍길동 [전화]***-****-0000 [입력일]22년4월1일
		SimpleDateFormat sdf = new SimpleDateFormat("yy년M월d일 친구됨");
		if(tel != null) {
			String post = tel.substring(tel.lastIndexOf('-')+1);
			return "[이름]" + name + "\t[전화]***-****-" + post + "\t[입력일]" + sdf.format(enterDate);	
		} else {
			return "[이름]" + name + "\t[전화]전화번호 없음\t\t[입력일]" + sdf.format(enterDate);
		}
		
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
}
