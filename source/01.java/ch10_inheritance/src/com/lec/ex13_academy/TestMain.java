package com.lec.ex13_academy;

public class TestMain {

	public static void main(String[] args) {
		Person st[] =	{	new Student("A01","강유미","JAVA반"),
							new Student("A02","홍길동","C++반"),
							new Staff("S01", "유길동", "운영지원팀"),
							new Staff("S01", "김길동", "취업지원팀"),
							new Gangsa("G01", "이길동", "객체지향")
						};
		for(Person p : st) {
			p.print();
		}
	}

}
