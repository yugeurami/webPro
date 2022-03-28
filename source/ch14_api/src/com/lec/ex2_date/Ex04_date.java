package com.lec.ex2_date;

import java.util.Date;

public class Ex04_date {
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance(); //싱글톤 클래스
//		GregorianCalendar cal = new GregorianCalendar();
		Date date = new Date();
		System.out.println(date); //가독성 저하
		int year = date.getYear()+1900; //년도
		int month = date.getMonth()+1; //월(Calendar.Month) 0,1,2,3.....11
		int day = date.getDate(); //일

		System.out.printf("%d년 %d월 %d일\n", year, month,day);
		
		//%tY(년) %tm(월) %td(일) %ta(요일) %tH(24시) %tp(오전/오후) %tL(12시) %tM(분) %tS(초)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분 %tS\n",date,date,date,date,date,date,date,date);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tp %1$tl시 %1$tM분 %1$tS\n",date);
		
		
	}	
}
