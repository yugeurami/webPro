package com.lec.loop;
//break : ���� ������ ��������
//continue : ���� ������ ���߰� �����κ����� ��
public class Ex05_breakContinue {

	public static void main(String[] args) {
		for( int i = 0 ; i<=5 ; i++ ) {
			if(i==3) {
				//break; �ݺ��� �� ���� ������
				continue;
			}
			System.out.println(i+". �ȳ�");
		}

	}

}
