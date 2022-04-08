package com.lec.ex14_account;

public class CreditLineAccount extends CheckingAccount {
	private int creditLine; //카드 한도

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) { // 잔액은 0
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
	public CreditLineAccount(String accountNo, String ownerName, long balance ,String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}
	@Override
	public void pay(String cardNo, int amount) {
		if(getCardNo().equals(cardNo)) { // 카드번호 확인, 순서가 바껴도 상관없음
			if(amount<=creditLine) { // 지불 가능한지
				creditLine -= amount;
				System.out.printf("%s(%s)님 %d원 지불해서 한도 %d원 남았습니다.\n", getOwnerName(), getAccountNo(), amount, creditLine);
			} else {
				System.out.printf("%s(%s)님 한도 %d원으로 %d원 지급 불가합니다.\n", getOwnerName(), getAccountNo(), creditLine, amount);
			}
		} else {
			System.out.println("올바른 카드 번호를 입력하세요.");
		}
	}
	
	

	
	
}
