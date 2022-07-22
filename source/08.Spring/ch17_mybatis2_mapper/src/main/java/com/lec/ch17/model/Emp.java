package com.lec.ch17.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
	private String dname;
	private String loc;
	
	//페이징 처리를 위한 속성 변수
	private int startRow;
	private int endRow;
}
