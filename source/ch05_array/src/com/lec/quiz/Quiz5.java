package com.lec.quiz;

//import java.util.Arrays;

//76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램 
public class Quiz5 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int[] sortArr = new int[arr.length];
		for(int i = 0 ; i<arr.length ; i++) {
			sortArr[i] = arr[i];
		}
		//오름차순 정렬: Arrays.sort(sortArr);
		for(int i = 0 ; i<sortArr.length-1 ; i++) {// i = 0~7까지
			for(int j = i+1 ; j<sortArr.length ; j++) {// j = i+1 ~ 7까지
				// i번째와 j번째 비교해서 i번째가 크면 교환
				if(sortArr[i] > sortArr[j]) { 
					int temp = sortArr[i]; // 사람처럼 교환이 안됨 다른 곳에 값을 저장해야함
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				} // if - 교환			
			} // for - j
		} // for - i
		System.out.print("원데이터");
		for (int i : arr) {
            System.out.printf("[%d]",i);
		}
		System.out.print("\n오름차순 데이터 정렬:");
	    for (int i : sortArr) {
	            System.out.printf("[%d]",i);
		}
		
	}

}
