package com.lec.condition;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {
		int kor, eng, mat;
		double avg;
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ������ : ");
		kor = sc.nextInt();
		System.out.print("���� ������ : ");
		eng = sc.nextInt();
		System.out.print("���� ������ : ");
		mat = sc.nextInt();
		
		int sum = kor + eng+ mat;
		avg = sum/3;
		
		if (kor>=avg) {
			System.out.printf("���������� ��� %.2f�� �̻��̴�.", avg);
		}else {
			System.out.printf("���������� ��� %.2f�� �̸��̴�.", avg);
		}if (eng>=avg) {
			System.out.printf("���������� ��� %.2f�� �̻��̴�.", avg);
		}else {
			System.out.printf("���������� ��� %.2f�� �̸��̴�.", avg);
		}if (mat>=avg) {
			System.out.printf("���������� ��� %.2f�� �̻��̴�.", avg);
		}else {
			System.out.println("���������� ���"+ avg + "�̸��̴�.");
		}
		
		sc.close();

	}

}
