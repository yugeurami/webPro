package com.lec.quiz;

//import java.util.Arrays;

//76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� �̵� ������ ũ�� ������ ��Ÿ���� ���α׷� 
public class Quiz5 {
	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92};
		int[] sortArr = new int[arr.length];
		for(int i = 0 ; i<arr.length ; i++) {
			sortArr[i] = arr[i];
		}
		//�������� ����: Arrays.sort(sortArr);
		for(int i = 0 ; i<sortArr.length-1 ; i++) {// i = 0~7����
			for(int j = i+1 ; j<sortArr.length ; j++) {// j = i+1 ~ 7����
				// i��°�� j��° ���ؼ� i��°�� ũ�� ��ȯ
				if(sortArr[i] > sortArr[j]) { 
					int temp = sortArr[i]; // ���ó�� ��ȯ�� �ȵ� �ٸ� ���� ���� �����ؾ���
					sortArr[i] = sortArr[j];
					sortArr[j] = temp;
				} // if - ��ȯ			
			} // for - j
		} // for - i
		System.out.print("��������");
		for (int i : arr) {
            System.out.printf("[%d]",i);
		}
		System.out.print("\n�������� ������ ����:");
	    for (int i : sortArr) {
	            System.out.printf("[%d]",i);
		}
		
	}

}
