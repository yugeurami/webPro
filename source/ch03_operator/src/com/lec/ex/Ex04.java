package com.lec.ex;
// �������� : &&(AND) ||(OR)
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		
		//&&������ ������ false�� ���� ���� ���� �� ��
		boolean result = ( (i>j) && (++j>h) );
		System.out.println("result="+result+"\t j="+j);
		
		result = ( (i<j) && (++j>h) ); 
		System.out.println("result="+result+"\t j="+j);
		
		//||������ ������ true�� �� ���� ���� �� ��
		result = (i<j) || (++j>h); 
		System.out.println("result="+result+"\t j="+j);
		
		result = (i>j) || (++j>h); 
		System.out.println("result="+result+"\t j="+j);
	}

}
