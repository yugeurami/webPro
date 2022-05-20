package com.test2;

public class Main {

	public static void main(String[] args) {
		Person[] person = {	new Student ("나학생", "JAVA반"),
							new Student ("홍길동","C++반"),
							new Staff ("나직원", "교무팀"),
							new Staff ("나도요", "취업지원팀"),
							new Gangsa ("나선생", "프로그래밍")};
		for(Person temp : person ) {
			System.out.println(temp);
		}
	}

}
