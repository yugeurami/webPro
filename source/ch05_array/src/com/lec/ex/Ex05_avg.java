package com.lec.ex;
import java.util.Scanner;
//����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾�, ���Ű�� ���
public class Ex05_avg {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] arrName = {"����","ö��","�浿","����","����"};
		int[] arrHeight = new int[arrName.length];
		int totalHeight = 0; // �Է¹��� Ű ���� ����
		for(int idx =0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"�� Ű�� : ");
			arrHeight[idx] = scanner.nextInt();
			totalHeight += arrHeight[idx];
		}
		System.out.println("���Ű�� "+(double)totalHeight/arrName.length);
		scanner.close();
	}

}
