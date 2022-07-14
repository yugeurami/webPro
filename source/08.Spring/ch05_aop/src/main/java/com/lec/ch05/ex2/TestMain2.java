package com.lec.ch05.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain2 {
	public static void main(String[] args) {
		String location = "classpath:META-INF/ex2/CTX.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		Student2 student = ctx.getBean("student", Student2.class);
		Worker2 worker = ctx.getBean("worker", Worker2.class);
		student.getStudentInfo();	// 핵심기능
		worker.getWorkerInfo();		// 핵심기능 
	}
}
