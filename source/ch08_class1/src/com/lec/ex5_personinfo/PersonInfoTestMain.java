package com.lec.ex5_personinfo;

public class PersonInfoTestMain {

	public static void main(String[] args) {
		PersonInfo[] person = {	new PersonInfo("ȫ�浿", 20, 'm'),
								new PersonInfo("ȫ���", 25, 'f')};
		for(PersonInfo p : person) {
			p.print();
		}
	}
}
