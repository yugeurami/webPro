package com.lec.ex;
/* ����������������
 * Hello, World!
 * ------------- printLine()
 * Hello, Java!
 * ~~~~~~~~~~~~~ printLine('~')
 * Hello, Hong!
 * ����������������
 */

public class Ex05_line {
	public static void main(String[] args) {
		printLine('��',40);
		System.out.println("\tHello, World!");
		printLine(40);
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, Hong!");
		printLine('��',40);
	}
	private static void printLine(int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print('-');
		}
		System.out.println(); // �Ű������� ���� ���ڸ�ŭ '-'���
	}
	
	private static void printLine(char c, int cnt) {
		for(int i = 0 ; i<cnt ; i++) {
			System.out.print(c);
		}
		System.out.println(); // �Ű������� ���� ���ڸ�ŭ �Ű������� ���� ���� ���
	}
	
	private static void printLine(char c) {
		for(int i = 0 ; i<30 ; i++) {
			System.out.print(c);
		}
		System.out.println(); // �Ű������� ���� c���� 30�� ����ϰ� ����
	}
	private static void printLine() { // returnŸ���� ���� �Ű������� ���� �޼ҵ�(�Լ�)
		for(int i = 0 ; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println(); //���� '-'20�� ����ϰ� ����
	}
}
