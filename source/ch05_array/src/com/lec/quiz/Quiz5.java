package com.lec.quiz;

import java.util.Arrays;

//76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 이들 값들을 크기 순으로 나타내는 프로그램 
public class Quiz5 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		Arrays.sort(arr);
	    for (int i : arr) {
	            System.out.printf("[%d]",i);
		}
		
	}

}
