package com.lec.loop;
//1~10���� ���� �� ¦���� ��
public class Quiz02for {

	public static void main(String[] args) {
		int tot = 0;
		
//		for (int i = 0 ; i<11 ; i+=2) {
//			tot += i;
//		}
		
		for (int i = 1 ; i<=10 ; i++) {
			if(i%2==0) {
				tot += i;
			}
		}
		System.out.println("1���� 10������ ¦���� ���� "+tot);
	}

}
