package com.lec.ex10_customer;

public class TestMain {
	public static void main(String[] args) {
		Customer customer = new Customer("홍","010-9999-9999","서울","1995-01-01");
		customer.buy(100000);
		customer.buy(900000);
		System.out.println(customer.infoString());
		
		Staff staff = new Staff("김","010-8888-8888","2022-09-01","개발");
		Person person = new Person("이","010-7777-7777");
		Person[] personArr = {customer, staff, person};
		for(int i = 0 ; i<personArr.length; i++) {
			System.out.println(personArr[i].infoString());
		}
		System.out.println("확장 for문");
		//배열 0~끝방까지 infoString
		for(Person p : personArr) {
			System.out.println(p.infoString());
		}
		//배열 0~끝방까지 buy(1000)
		for(Person p : personArr) {
			if(p instanceof Customer) { // p변수가 Customer형 객체인가?
				((Customer)p).buy(1000);
			}else {
				System.out.println("buy는 Customer만 가능합니다");
			} // if
		}// for
	}// main
} // class
