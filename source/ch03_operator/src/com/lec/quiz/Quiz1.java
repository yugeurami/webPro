package com.lec.quiz;
//����ڷκ��� �Է¹��� ���� 3�� ������� ���� ���
import java.util.Scanner;

public class Quiz1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("���� �Է��ϼ��� : ");
		int su = scanner.nextInt(); // ����ڷκ��� ���� �Է� �ޱ�
		String result = su%3 == 0 ? "�Է��Ͻ� ���� 3�� ���" :"�Է��Ͻ� ���� 3�� ����� �ƴ�";
		System.out.println(result);
		scanner.close();
	}

}
