package com.lec.ex4_access;

import com.lec.ex3_access.AccessTest;

public class AccessTestMain {

	public static void main(String[] args) {
//		com.lex.ex3_access.AccessTest obj; import하지 않고 불러오기
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
//		System.out.println(obj.defaultMember);
//		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
//		obj.privateMethod();
//		obj.defaultMethod();
//		obj.protectedMethod();
		obj.publicMethod();
	}

}
