package com.lec.ex;
//변수 선언 방법들
public class VarEx04 {

	public static void main(String[] args) {
		// 1. 자료형 변수명 - 변수 선언과 할당을 분리함
		int num1;
		num1 = 10;
		System.out.println("num1="+num1);
		// 2. 자료형 변수명 = 초기값 - 변수 선언과 할당을 동시에 (초기화)
		int num2 = 20;
		// 3. 자료형 변수명1, 변수명2, ... 변수명n - 동일 자료형 변수 다수 선언
		int num3, num4;
		num3 = 30; num4 = 40;
		System.out.printf("num3=%d, num4=%d\n", num3, num4);
		// 4.자료형 변수명1=값1, 변수명2=값2,... 변수명n=값n; - 동일 자료형 변수 다수 선언과 초기화
		int num5=50, num6=60, num7;
		num7=70;
		
		
	}

}