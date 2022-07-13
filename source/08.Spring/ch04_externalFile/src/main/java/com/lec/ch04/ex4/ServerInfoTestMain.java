package com.lec.ch04.ex4;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;


public class ServerInfoTestMain {
	public static void main(String[] args) {
		String config = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("dev중? run중?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev";
		}else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		}else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다");
			System.exit(0);
		}
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.load("classpath:META-INF/ex4/CTX_dev.xml", "classpath:META-INF/ex4/CTX_run.xml");
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("IPNum=" + info.getIpNum());
		System.out.println("portNum=" + info.getPortNum());
		System.out.println("userId=" + info.getUserId());
		System.out.println("pw=" + info.getUserPw());
		ctx.close();
	}
}
