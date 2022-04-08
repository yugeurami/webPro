package com.lec.ex14_account;

public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	public Account() {
		
	}; 
	public Account(String accountNo, String ownerName) { // 생성자 역할 : 데이터 초기화
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		System.out.printf("%s(%s)님 계좌 개설 감사합니다. 돈은 왜 안 갖고 오셨어요\n", ownerName, accountNo);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		System.out.printf("%s(%s)님 %d원 입금 계좌 개설 감사합니다.\n", ownerName, accountNo, balance);
	}
	public void deposit(int money) { //예금은 무조건 양수 money가 들어오면 예금처리
		if(money>=0) {
			balance += money;
			System.out.printf("%s(%S)님 %d원 입금 완료했습니다. 현재 잔액:%d\n", ownerName,accountNo, money, balance);
		}else {
			System.out.println("입력이 잘못됐습니다.");
		}
	}
	public void withdraw(int money) {
		if(money<=balance) {
			balance -= money;
			System.out.printf("%s(%S)님 %d원 출금 완료했습니다. 현재 잔액:%d\n", ownerName,accountNo, money, balance);
		}else {
			System.out.println(ownerName+"님 잔액이 부족하여 인출이 불가합니다.");
		}
	}
	public String infoPrint() {
		return String.format("%s(%s)님 잔액 : %d원", ownerName, accountNo, balance);
		// return ownerName + "("+ accountNo + ")님 잔액 : " + balance + "원";
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
		
}
