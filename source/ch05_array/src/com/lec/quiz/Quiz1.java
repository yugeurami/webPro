package com.lec.quiz;
//배열에 담긴 값을 더하는 프로그램
public class Quiz1 {
	public static void main(String[] args) {
		int[] arr =  {10, 20, 30, 40, 50};
		int tot = 0;
		for(int i = 0 ; i<arr.length ; i++) {
			tot += arr[i];
		}
//		for(int temp : arr) {
//			tot += temp;
//		} 확장 for문
		System.out.println("배열에 담긴 숫자들의 합은 "+tot);
	}
}