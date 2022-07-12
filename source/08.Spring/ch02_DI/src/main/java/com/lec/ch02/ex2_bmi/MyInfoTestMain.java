package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyInfoTestMain {

	public static void main(String[] args) {
		String resourceLocation = "applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		//MyInfo myinfo = (MyInfo) ctx.getBean("myInfo");
		MyInfo myinfo = ctx.getBean("myInfo", MyInfo.class);
		myinfo.getInfo();
		ctx.close();
	}

}
