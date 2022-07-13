package ch03_diLifeCycleConfig;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch03.ex2.OtherPerson;
import com.lec.ch03.ex2.Person;

public class TestMain {

	public static void main(String[] args) {
		// IOC 컨테이너 생성(환경설정)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		// 파싱
		ctx.load("classpath:META-INF/ex2/applicationCTX.xml");
		ctx.refresh(); // 빈 생성
		System.out.println("----------------------------------");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
		OtherPerson otherPerson = ctx.getBean("otherPerson", OtherPerson.class);
		System.out.println(otherPerson);
		System.out.println("----------------------------------");
		ctx.close();
		System.out.println("빈 소멸");
	}

}
