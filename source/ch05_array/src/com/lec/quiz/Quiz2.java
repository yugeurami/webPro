package com.lec.quiz;
//2���� �迭�� ����� ���� �հ踦 ���Ͻÿ�
public class Quiz2 {

	public static void main(String[] args) {
		int[][] arr = { {5,5,5,5,5}, 
						{10,10,10,10,10}, 
						{20,20,20,20,20}, 
						{30,30,30,30,30}};
		int tot = 0;
		for(int i = 0 ; i<arr.length ; i++) {
			for(int j = 0 ; j<arr[i].length ; j++) {
				tot += arr[i][j];
			}
		}
		System.out.println("2���� �迭�� ������ "+tot);
	}

}
