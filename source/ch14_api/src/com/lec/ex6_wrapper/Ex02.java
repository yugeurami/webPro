package com.lec.ex6_wrapper;

public class Ex02 {

	public static void main(String[] args) {
		double i = 10.1;
		double j = 10.1;
		double sum = i+j;
		System.out.println("합은 "+sum);
		System.out.println(i==j ? "두 int는 같다" : "두 int는 다르다");
		Double iObj = new Double(10.1);
		Double jObj = 10.1; // 위 아래는 동일
		sum = iObj+ jObj; //sum = iObj.intValue() + jObj.intValue();
		System.out.println("합은 "+sum);
		System.out.println(iObj.equals(j) ? "같다": "다르다");
		System.out.println(iObj == jObj ? "주소가 같다" : "주소가 다르다");
			
		}
	
}
