package com.lec.ex3_access;

public class AccessTestMain {

	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(object.privateMember);
		System.out.println(obj.defaultMember);
		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
//		obj.privateMethod;
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();
	}

}
