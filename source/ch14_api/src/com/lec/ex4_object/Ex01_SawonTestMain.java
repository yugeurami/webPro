package com.lec.ex4_object;
// Sawon s1 = new Sawon("a01", "홍길동", "COMPUTER") - 오늘 입사
// Sawon s2 = new Sawon("a02", "신길동", "COMPUTER", 2022, 3 ,24) - 3월 24일 입사
public class Ex01_SawonTestMain {
	public static void main(String[] args) {
		Sawon s1 = new Sawon("a01", "홍길동", Dept.COMPUTER);
		Sawon s2 = new Sawon("a02", "신길동", Dept.HUMANRESOURCES, 2022, 3 ,24);
		System.out.println(s1);
		System.out.println(s2);
		Sawon2 s3 = new Sawon2("c01", "마길동", Dept2.PLANNING, 2022, 3, 10); 
		System.out.println(s3);
	}
}
