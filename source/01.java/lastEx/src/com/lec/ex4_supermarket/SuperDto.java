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
		super();
		this.cid = cid;
		this.cname = cname;
		this.ctel = ctel;
	}

	//출력용
	public SuperDto(int cid, String cname, String ctel, String lname, int cpoint, int needpay) {
		this.cid = cid;
		this.cname = cname;
		this.ctel = ctel;
		this.lname = lname;
		this.cpoint = cpoint;
		this.needpay = needpay;
	}

	@Override
	public String toString() {
		return cid + "\t" + ctel + "\t" + cname + "\t" + cpoint + "\t"
				+ camount + "\t" + lname + "\t" + needpay;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtel() {
		return ctel;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}

	public int getNeedpay() {
		return needpay;
	}

	public void setNeedpay(int needpay) {
		this.needpay = needpay;
	}

	public int getCamount() {
		return camount;
	}

	public void setCamount(int camount) {
		this.camount = camount;
	}
	
	
}
