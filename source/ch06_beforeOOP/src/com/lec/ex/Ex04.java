package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex04 {
	
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);
		Arithmetic ar = new Arithmetic(); //static�� �ƴ� �޼ҵ�� �ν��Ͻ��� ����������
		System.out.println("-7�� ���밪�� "+ar.abs(-7));
		
	}
}
