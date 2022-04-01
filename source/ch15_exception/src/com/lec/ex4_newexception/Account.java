package com.lec.ex4_newexception;

public class Account {
	private String accountNo;
	private String ownerName;
	private int balance;
	public Account(String accountNo, String ownerName) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
	}
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	// 예금 : 예금전 계좌정보출력 => 예금 -> 예금 후 계좌정보 출력
	public void deposit(int amount) { // 예금
		System.out.println("예금전 : "+ this);
		balance += amount;
		System.out.println(amount+"원 예금 후 :"+this);
	}
	//출금 : 잔액확인 => 출금 전 계좌정보출력 => 출금 -> 출금 후 계좌정보 출력
	public void withdraw(int amount) throws Exception {
		if(balance<amount) { // 잔액부족으로 출금되지 않음 : 강제로 예외 발생
			throw new Exception(amount+"원 출금하기에는 잔액("+balance+")이 부족합니다");
		}
		System.out.println("출금전: "+this);
		balance -= amount;
		System.out.println(amount+"원 출금 후: "+this);
	}
	@Override
	public String toString() {
		return  "계좌번호:"+accountNo+"\t예금주:"+ownerName+"\t잔액:"+balance;
	}
	
}
