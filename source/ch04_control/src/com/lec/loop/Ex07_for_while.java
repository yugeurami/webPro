package com.lec.loop;
//1~100���� 3�� ����� �ո� ������ ���
public class Ex07_for_while {

	public static void main(String[] args) {
		int tot = 0;
//		for (int i = 1 ; i<=100 ; i++) {
//			if(i%3==0) {
//				tot += i;
//			}
//		}
//		System.out.println("1���� 100���� 3�� ����� ���� "+tot);
		
		int i = 1;
		while(i<=100) {
			if(i%3==0) {
				tot +=i;
			}
			++i;
		}
		System.out.println("1���� 100���� 3�� ����� ���� "+tot);
	}

}
