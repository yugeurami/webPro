package com.lec.condition;

public class Ex01_if {

	public static void main(String[] args) {
		int seoulLunchPrice = 5000;
		if(seoulLunchPrice >= 8000) {
			System.out.println("���� ���ɰ� ��γ׿�");
		}else if(seoulLunchPrice >= 6000) {
			System.out.println("���� �䰪 ����. �׷�");
		}else if(seoulLunchPrice >=5000) {
			System.out.println("����");
		}else {
			System.out.println("�Ĵ� ���� ���ұ�� �����ǳ�");
		}

	}

}
