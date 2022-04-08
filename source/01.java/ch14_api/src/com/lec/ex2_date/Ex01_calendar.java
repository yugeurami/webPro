package com.lec.ex2_date;

import java.util.Calendar;

public class Ex01_calendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); //싱글톤 클래스
		System.out.println(cal); //가독성 저하
		int year = cal.get(Calendar.YEAR); //년도
		int month = cal.get(Calendar.MONTH)+1; //월(Calendar.Month) 0,1,2,3.....11
		int day = cal.get(Calendar.DAY_OF_MONTH); //일
		int week = cal.get(Calendar.DAY_OF_WEEK); //일1, 월2, 화3, 수4 ....토7
		int ampm = cal.get(Calendar.AM_PM);
		int hour = cal.get(Calendar.HOUR);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY)+2;
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int millisec = cal.get(Calendar.MILLISECOND);
		
		System.out.printf("%d년 %d월 %d일",year, month, day);
		switch(week) {
		case 1: System.out.print("일요일");break;
		case 2: System.out.print("월요일");break;
		case 3: System.out.print("화요일");break;
		case 4: System.out.print("수요일");break;
		case 5: System.out.print("목요일");break;
		case 6: System.out.print("금요일");break;
		case 7: System.out.print("토요일");break;
		}
		System.out.println(ampm == 0 ? "오전" : "오후");
		System.out.printf("%d시 %d분 %d초 %d\n", hour, minute, second, millisec);
		System.out.printf("%d시 %d분 %d초 %d\n", hour24, minute, second, millisec);
		
		//%tY(년) %tm(월) %td(일) %ta(요일) %tH(24시) %tp(오전/오후) %tL(12시) %tM(분) %tS(초)
		System.out.printf("%tY년 %tm월 %td일 %ta요일 %tp %tl시 %tM분 %tS",cal,cal,cal,cal,cal,cal,cal,cal);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$ta요일 %1$tp %1$%tl시 1$%tM분 1$%tS",cal);
		
		
	}	
}
