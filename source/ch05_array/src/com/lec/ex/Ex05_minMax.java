package com.lec.ex;
import java.util.Scanner;
//����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾�, ���Ű�� ���
//����� �̸��� Ű, �ִܽ� �̸��� Ű ���
public class Ex05_minMax {
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
		scanner.close();//�� ���Ŀ��� scanner ���Ұ���
		//����� �̸��� Ű, �ִܽ� �̸��� Ű ���
		int minHeight = 999, minIdx = 0; //�ִܽ� Ű�� index(��ġ)
		int maxHeight = 0, maxIdx = 0;   //����� Ű�� index(��ġ)
		for(int i = 0 ; i<arrName.length ; i++) {
			if(arrHeight[i]<minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			} // if �ִܽ� Ű�� �ִܽ� indexã��
		}
		for(int i = 0 ; i<arrName.length ; i++) {
			if(arrHeight[i]>maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
			} // if ����� Ű�� ����� indexã��
		}
		System.out.printf("����� �л��� %s, Ű�� %dcm \n", arrName[maxIdx], maxHeight);
		System.out.printf("�ִܽ� �л��� %s, Ű�� %dcm", arrName[minIdx], minHeight);
	}
}
