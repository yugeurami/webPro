package com.lec.ch03.ex2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person implements InitializingBean, DisposableBean, EnvironmentAware {
	private String name;
	private String tel;
	
	@Override
	public void setEnvironment(Environment environment) {
		// 객체를 만들어서 환경을 가지고 올 때
		System.out.println("Person 형 bean 객체 생성하자마자 실행1 : setEnvironment() 호출");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// 빈을 생성하자마자 실행하는 method
		System.out.println("Person 형 bean 객체 생성하자마자 실행2 : afterPropertiesSet() 호출");
	}

	@Override
	public void destroy() throws Exception {
		// 빈을 삭제하려고 할 때 실행되는 method
		System.out.println("Person 형 bean 객체 소멸 바로 전 실행 : destroy() 호출");
	}

}
