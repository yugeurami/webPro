package com.lec.quiz;
//76,45,34,89,100,50,90,92  8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� ���� �հ��  ��� �׸��� �ִ밪�� �ּҰ�
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
		System.out.println("�հ�� "+tot);
		System.out.println("����� "+(double)tot/arr.length);
		System.out.println("�ּҰ��� "+min);
		System.out.println("�ִ밪�� "+max);
	}

}
