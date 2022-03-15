package com.lec.ex;
// 일반 for문 vs 확장 for문(배열 출력)
public class Ex02 {

	public static void main(String[] args) {
		int[] arr = new int[3]; //{0,0,0}
		
		for(int idx = 0 ; idx<arr.length ; idx++) {
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}//일반 for문 이용한 출력
		
		for(int temp : arr) {
			System.out.println(temp);
		}//확장 for문을 이용한 출력
		
		for(int i = 0 ; i<arr.length ; i++) {// 일반 for문을 이용한 배열 변경 가능
			arr[i] = 5;
		}
		for(int temp : arr) {
			System.out.println(temp);
		}
		
		for(int temp : arr) { // 확장 for문을 이용한 배열 변경 불가능
			temp = 9; //temp 값이 바뀌는 것 배열은 영향을 주지 않음
		}
		System.out.println("수정 후");
		for(int temp : arr) {
			System.out.println(temp);
		}

	}

}
