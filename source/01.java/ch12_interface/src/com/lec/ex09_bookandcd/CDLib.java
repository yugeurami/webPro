package com.lec.ex09_bookandcd;

public class CDLib extends CDInfo implements ILendable {
	private String borrwer; 		
	private String checkOutDate;	
	private byte state;	
	
	
	public CDLib(String cDNo, String cDTitle, String bookNo) {
		super(cDNo, cDTitle, bookNo);
	}
	
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(state == STATE_BORROWED) { 
			System.out.println(super.getCDTitle()+"CD는 대출중입니다");
			return;
		}
		
		this.borrwer = borrower;
		this.checkOutDate = checkOutDate;
		state = STATE_BORROWED; 
		System.out.println(borrower+"님,\t"+super.getCDTitle()+ "가 대출 처리되었습니다\n대출일 : "+checkOutDate);		
	}
	@Override
	public void checkIn() {
		if(state == STATE_NORMAL) { 
			System.out.println(super.getCDTitle()+"는 이미 반납됐습니다");
			return;
		}
		borrwer = null;
		checkOutDate = null;
		state = STATE_NORMAL; 
		System.out.println(super.getCDTitle()+"가 반납 완료되었습니다");
	}

	@Override
	public void printState() {
		if(state == STATE_NORMAL) {
			System.out.println(super.getCDNo() + "\t" + super.getCDTitle() + "(" + super.getBookNo() + ")\t대출가능");
		} else if(state == STATE_BORROWED) {
			System.out.println(super.getCDNo() + "\t" + super.getCDTitle() + "(" + super.getBookNo() + ")\t대출중");
		} else {
			System.out.println(super.getCDNo() + "\t" + super.getCDTitle() + "(" + super.getBookNo() + ")\t이상해");
		}
	}

	public byte getState() {
		return state;
	}
	
}
