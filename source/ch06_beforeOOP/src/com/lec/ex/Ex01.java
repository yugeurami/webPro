package com.lec.ex;
// 1~10���� ������ ���� ����ϰ� �� ���� ¦������ Ȧ������ ���
public class Ex01 {
	public static void main(String[] args) {
		int tot = 0;
		for(int i = 1 ; i<11 ; i++) {
			tot += i;
		}
		System.out.println("1���� 10���� ������ ���� "+tot+"�Դϴ�");
		String msg;
		if(tot%2==0) {
			msg = "¦���Դϴ�";
		}else {
			msg = "Ȧ���Դϴ�";
		}
		System.out.println(msg);
	}

}
