package com.lec.ex6_wrapper;

public class Ex01 {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		int sum = i+j;
		System.out.println("합은 "+sum);
		System.out.println(i==j ? "두 int는 같다" : "두 int는 다르다");
		Integer iObj = new Integer(10);
		Integer jObj = 10; // 위 아래는 동일
		sum = iObj+ jObj; // sum = iObj.intValue() + jObj.intValue();
		System.out.println("합은 "+sum);
		System.out.println(iObj.equals(jObj) ? "두 wrapper 객체 값은 같다": "두 wrapper 객체 값은 다르다");
		System.out.println(iObj == jObj ? "주소가 같다" : "주소가 다르다");
			
		}
	
}
