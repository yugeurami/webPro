package com.lec.ex;
// ��������: ++ --
public class Ex02 {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; // n1���� �ϳ� ����
		
		System.out.println("n1="+n1+"\t n2="+n2);
		
		int n3 = 10;
		int n4 = n3--; // ;���Ŀ� n3���� �ϳ� ���� 
		
		System.out.println("n3="+n3+"\t n4="+n4);
		
		int n5 = 10;
		++n5; // n5���� �ϳ� ����
		int n6 = n5; // ������ n5���� n6��
		
		System.out.println("n5="+n5+"\t n6="+n6);
		
		int n7 = 10;
		int n8 = n7; // n7�� ���� n8�� ����
		++n7; // n7���� �ϳ� ����
		
		System.out.println("n7="+ n7+"\t n8="+ n8);

	}

}
