package com.lec.quiz;

import java.util.Arrays;

//76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� �̵� ������ ũ�� ������ ��Ÿ���� ���α׷� 
public class Quiz5 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		Arrays.sort(arr);
	    for (int i : arr) {
	            System.out.printf("[%d]",i);
		}
		
	}

}
