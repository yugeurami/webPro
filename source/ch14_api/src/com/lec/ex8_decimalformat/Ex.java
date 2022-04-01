package com.lec.ex8_decimalformat;

import java.text.DecimalFormat;

public class Ex {
	public static void main(String[] args) {
		double num = 1230000000000L;  //1.23E13 = 10의 13승
		DecimalFormat df0 = new DecimalFormat("00000000"); // 0이 8자리 : 자리수를 0으로 하면 반드시 출력
		System.out.println(df0.format(num));
		DecimalFormat df1 = new DecimalFormat("########"); // #이 8자리 : 8자리 출력
		System.out.println(df1.format(num));
		DecimalFormat df2 = new DecimalFormat("0,000.000"); //3자리마다 콤마. 소숫점 3자리 출력
		System.out.println(df2.format(num));
		DecimalFormat df3 = new DecimalFormat("#,###.##%");
		System.out.println(df3.format(num));
		DecimalFormat df4 = new DecimalFormat("#.##E##");
	}
}
