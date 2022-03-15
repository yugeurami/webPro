package com.lec.ex;
// 1~10���� ������ ���� ����ϰ� �� ���� ¦������ Ȧ������ ���
public class Ex02 {
	public static void main(String[] args) {
		
		int tot = sum(10); //sum ȣ��
		System.out.print("1~10���� �������� "+tot+", ");
		System.out.println(evenOdd(tot));
		
		tot = sum(10, 100);
		System.out.print("10~100���� �������� "+tot+", ");
		System.out.println(evenOdd(tot));
	}
	
	private static int sum(int to) { // �Լ��� �����ε�
		int result = 0;
		for (int i = 1 ; i<=to ; i++) {
			result += i;
		}
		return result;
	}
	
	private static int sum(int from, int to) { // from ~ to���� ������ ��� return
		int result = 0;
		for (int i = from ; i<=to ; i++) {
			result += i;
		}
		return result; // return�� ������ ȣ���� ������ ���� ���
	}
	
	private static String evenOdd(int tot) {
		return tot%2==0 ? "¦���Դϴ�" : "Ȧ���Դϴ�";
//		if(tot%2 == 0) {
//			return "¦���Դϴ�";
//		}else {
//			return "Ȧ���Դϴ�";
//		} 
	}

}
