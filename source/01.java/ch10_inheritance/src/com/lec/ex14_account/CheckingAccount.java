package com.lec.ex14_account;

public class CheckingAccount extends Account {
	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public void pay(String cardNo, int amount) {
		if(this.cardNo.equals(cardNo)) { // 카드번호 확인, 순서가 바껴도 상관없음
			if(amount<=getBalance()) { // 지불 가능한지
				setBalance(getBalance() - amount);
				System.out.printf("%s(%s)님 %d원 지불해서 잔액 %d원 남았습니다.\n", getOwnerName(), getAccountNo(), amount, getBalance());
			} else {
				System.out.printf("%s(%s)님 잔액 %d원으로 %d원 지급 불가합니다.\n", getOwnerName(), getAccountNo(), getBalance(), amount);
			}
		} else {
			System.out.println("올바른 카드 번호를 입력하세요.");
		}
	}
	public String getCardNo() {
		return cardNo;
	}
	
}
