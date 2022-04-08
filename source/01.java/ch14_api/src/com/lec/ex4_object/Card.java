package com.lec.ex4_object;
//
public class Card {
	private char kind;
	private int num;
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "카드는 " + kind + "," +num;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj !=null && obj instanceof Card ) {
			boolean kindChk = (kind == ((Card)obj).kind);
			boolean numChk = (num == ((Card)obj).num);
			return kindChk && numChk;
		}
		return false;
	}
}
