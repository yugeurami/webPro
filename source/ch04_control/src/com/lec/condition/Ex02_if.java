package com.lec.condition;
// ����ڷ� ���� �� ���� �Է¹޾� ù��° ���� �� ū�� �ι�° ���� �� ū�� ���
import java.util.Scanner;

public class Ex02_if {

	public static void main(String[] args) {
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� : ");
		num1 = sc.nextInt(); // ������ �Է��ϰ� ���͸� ������ �ش� ������ num1 �Ҵ�
		System.out.print("�ι�° ���� : ");
		num2 = sc.nextInt();
		if(num1 > num2) {
			System.out.println("ù��° ���� "+ (num1-num2) + "��ŭ �� Ů�ϴ�");
		}else if(num2 > num1) {
			System.out.printf("�ι�° ���� %d��ŭ �� Ů�ϴ�\n", num2-num1);
		}else{
			System.out.println("�Է��� �� ���� �����ϴ�");
		}
		sc.close();
		

	}

}
