package com.lec.ex2_date;

import java.util.GregorianCalendar;

public class Ex03_gc_term {

	public static void main(String[] args) {
		GregorianCalendar gcNow = new GregorianCalendar(); //지금 현재의 날짜와 시간
		GregorianCalendar gcThat = new GregorianCalendar(2022, 2, 11, 9, 30); //개강시점의 날짜와 시간
		long start = gcThat.getTimeInMillis();
		long end = gcNow.getTimeInMillis();
		int day = (int)(end-start) / (1000*60*60*24);
		System.out.println("개강일부터 현재까지 몇일 지났는지 : "+day);
		
	}

}
