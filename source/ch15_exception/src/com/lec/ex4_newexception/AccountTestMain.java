package com.lec.ex4_newexception;

public class AccountTestMain {

	public static void main(String[] args) {
		Account obj1 = new Account("111-111", "홍길동");
		Account obj2 = new Account("222-2222", "신길동", 2000);
		obj1.deposit(1000);
		obj2.deposit(1000);
		try {
			obj1.withdraw(500);
		} catch (Exception e) {
			System.out.println("예외 메세지 : "+e.getMessage());
		} // withdraw 메소드 선언시 throws가 있으면 호출시에 try-catch
		try {
			obj2.withdraw(30000);
		} catch (Exception e) {
			System.out.println("예외 메세지 : "+e.getMessage());
		}
	}

}
