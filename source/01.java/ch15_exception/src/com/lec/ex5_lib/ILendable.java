package com.lec.ex5_lib;

public interface ILendable {
	public /*static final*/ byte STATE_BORROWED = 1; // 대출중
	public byte STATE_NAMAL = 0; // 대출가능
	public void checkOut(String borrower) throws Exception; // 대출
	public void checkIn() throws Exception; //반납
}
