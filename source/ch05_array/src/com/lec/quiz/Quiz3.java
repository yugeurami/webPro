package com.lec.quiz;
//76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 값에 합계와  평균 그리고 최대값과 최소값
public class Quiz3 {

	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int tot = 0;
		int max = 0;
		int min = 999;
		for(int i = 0 ; i<arr.length ; i++) {
			if(arr[i]<min) {
				min = arr[i];
			} 
			if(arr[i]>max) {
				max = arr[i];
			}
			tot += arr[i];
		}
		System.out.println("합계는 "+tot);
		System.out.println("평균은 "+(double)tot/arr.length);
		System.out.println("최소값은 "+min);
		System.out.println("최대값은 "+max);
	}

}
