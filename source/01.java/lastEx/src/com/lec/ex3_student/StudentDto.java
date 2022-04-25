package com.lec.ex3_student;

public class StudentDto {
	private int rank;
	private int sno;
	private String sname;
	private String mname;
	private int score;
	public StudentDto() {}
	
	public StudentDto(int sno, String sname, String mname, int score) {
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}

	public StudentDto(int rank, int sno, String sname, String mname, int score) {
		this.rank = rank;
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
	}
	
	@Override
	public String toString() {
		if(rank!=0) {
			return rank + "등\t" + sno + "\t" + sname + "\t"  + mname + "\t" + score + "\t";
		} else {
			return sno + "\t" + sname + "\t"  + mname + "\t" + score + "\t";
		}
		
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isReg() {
		return reg;
	}

	public void setReg(boolean reg) {
		this.reg = reg;
	}
}
