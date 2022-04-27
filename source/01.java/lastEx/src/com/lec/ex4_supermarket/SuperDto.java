package com.lec.ex4_supermarket;

public class SuperDto {
	private int cid;
	private String cname;
	private String ctel;
	private String lname;
	private int cpoint;
	private int needpay;
	private int camount;
	public SuperDto() {}
	
	//입력용
	public SuperDto(int cid, String cname, String ctel) {
		this.cid = cid;
		this.cname = cname;
		this.ctel = ctel;
	}

	//출력용
	public SuperDto(int cid, String cname, String ctel, String lname, int cpoint, int needpay, int camount) {
		this.cid = cid;
		this.cname = cname;
		this.ctel = ctel;
		this.lname = lname;
		this.cpoint = cpoint;
		this.needpay = needpay;
		this.camount = camount;
	}
	

	@Override
	public String toString() {
		return cid + "\t" + ctel + "\t" + cname + "\t" + cpoint + "\t"
				+ camount + "\t" + lname + "\t" + needpay + "\n";
	}

	public int getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}

	public String getCtel() {
		return ctel;
	}

	public String getLname() {
		return lname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public int getNeedpay() {
		return needpay;
	}

	public int getCamount() {
		return camount;
	}

	
}
