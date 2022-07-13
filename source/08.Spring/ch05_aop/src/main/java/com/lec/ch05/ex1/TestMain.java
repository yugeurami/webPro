package com.lec.ch05.ex1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		String location = "classpath:META-INF/ex1/applicationCTX1.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		Student student = ctx.getBean("student", Student.class);
		Worker worker = ctx.getBean("worker", Worker.class);
		student.getStudentInfo();	// 핵심기능
		worker.getWorkerInfo();		// 핵심기능
	}
}
