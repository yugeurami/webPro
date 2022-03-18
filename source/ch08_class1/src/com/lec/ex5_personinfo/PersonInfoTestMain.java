package com.lec.ex5_personinfo;

public class PersonInfoTestMain {

	public static void main(String[] args) {
		PersonInfo[] person = {	new PersonInfo("홍길동", 20, 'm'),
								new PersonInfo("홍길순", 25, 'f')};
		for(PersonInfo p : person) {
			p.print();
		}
	}
}
