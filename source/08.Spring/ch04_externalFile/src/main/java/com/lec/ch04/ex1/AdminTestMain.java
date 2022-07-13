package com.lec.ch04.ex1;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class AdminTestMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 컨테이너 생성
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources(); // env 속성과 속성값 set
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:META-INF/ex1/admin.properties"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("admin.id = " + env.getProperty("admin.id"));
		System.out.println("admin.pw = " + env.getProperty("admin.pw"));
		
		// env에 외부 설정 파일 속성들을 추가한 후 bean 생성
		ctx.load("classpath:META-INF/ex1/CTX.xml");
		ctx.refresh();
		Admin admin = ctx.getBean("admin", Admin.class);
		System.out.println("adminId : " + admin.getAdminId());
		System.out.println("adminPw : " + admin.getAdminPw());
		ctx.close();
	}
}
