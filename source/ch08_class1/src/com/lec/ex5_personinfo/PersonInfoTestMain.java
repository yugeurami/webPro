package com.lec.ex5_personinfo;

public class PersonInfoTestMain {

	public static void main(String[] args) {
		PersonInfo[] person = {	new PersonInfo("È«±æµ¿", 20, 'm'),
								new PersonInfo("È«±æ¼ø", 25, 'f')};
		for(PersonInfo p : person) {
			p.print();
		}
	}
}
