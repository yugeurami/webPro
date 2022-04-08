package com.lec.ex4_object;
//Sawon2 s3 = new Sawon("c01", "마길동", Dept2.COMPUTER)
//Sawon s1 = new Sawon("a01", "홍길동", Dept.COMPUTER) - 오늘 입사
//Sawon s2 = new Sawon("a02", "신길동", Dept.HUMANRESOURCES, 2022, 3 ,24) - 3월 24일 입사
//System.out.println(s1) =>[사번]a01 [이름]홍길동 [부서]COMPUTER [입사일]2022년3월24일(목)

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon2 {
	private String 	num; 		//사번
	private String 	name; 		//이름
	private Dept2 	dept; 		//부서
	private Date 	hiredate;	//입사일
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일(E)");
	public Sawon2(String num, String name, Dept2 dept) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		hiredate = new Date(); // 입사일을 지금으로
	}
	public Sawon2(String num, String name, Dept2 dept, int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.dept = dept;
//		hiredate = new Date(y-1900, m-1, d); // 입사일 y년 m월 d일로
		hiredate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	
	@Override
	public String toString() {
		String dStr = ""+ dept;
		if(dStr.length()>10) {
			return "[사번]" + num +"\t[이름]"+name + "\t[부서]" + dept +"\t[입사일]"+ sdf.format(hiredate);
		} else {
			return "[사번]" + num +"\t[이름]"+name + "\t[부서]" + dept +"\t\t[입사일]"+ sdf.format(hiredate);
		}
	}
	
}
