package com.lec.ex;
// println(); �ܼ�â�� ���(��������)
// print();   �ܼ�â�� ����(���������)
// printf();   �ܼ�â�� Ư�� �������� ��� (���������)
public class VarEx02 {

	public static void main(String[] args) {
		//������ Ÿ�� ������ =�ʱⰪ
		int i = 10; //4byte¥�� i��� �޸� ������ 10�� �Ҵ�
		byte j  = 10; //2byte¥�� j��� �޸� ������ 10�� �Ҵ�
		double h = 10.15;
		i = 5;
		System.out.println("i="+i+"\t j="+j+"\t h="+h);
		char c1 = 'A';
		char c2 = 'B';
		System.out.print("c1="+c1+"\t c2="+c2+"\n"); // "\n" : ����
		System.out.printf("c1=%c \t c2=%c\n", c1, c2);
		//%c ����, %d ����, %f �Ǽ�, %s ���ڿ�
		System.out.printf("i=%d, j=%d, h=%4.1f \n", i, j, h);
		//%4.1f=��ü 4�ڸ� �߿� �Ҽ��� ���ڸ������� ���, �˾Ƽ� �ݿø�
		System.out.println("��");
	}

}
