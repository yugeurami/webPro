package com.lec.condition;

import java.util.Scanner;
// 0 <= Math.random() < 1
// 0 <= Math.random()*3 < 3
// (int)(Math.random()*3) : 0,1,2
public class Quiz05_if_srpGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com;
		com = (int)(Math.random()*3);
		System.out.println("����(0),����(1),��(2) �� �ϳ��� �����ϼ��� : ");
		you = sc.nextInt(); // ������ �Է� ����
		if(you == 0) {
			System.out.print("����� ���� \t");
		}else if (you == 1) {
			System.out.print("����� ���� \t");
		}else if(you == 2) {
			System.out.print("����� ���ڱ� \t");
		}else {
			System.out.println("����� �߸� �¾��. ����");
			you = 3;//������ ���� ����
		}
		if(you !=3) {//��ǻ�Ͱ� �� �Ͱ� ���� ���
			String msg = (com == 0)? "��ǻ�ʹ� ����" : (com == 1)? "��ǻ�ʹ� ����" : "��ǻ�ʹ� ���ڱ�";
			System.out.println(msg);
			if(you==0) {
				if(com==0) {
					System.out.println("���º� �Դϴ�");
				}else if(com == 1) {
					System.out.println("��ǻ�Ͱ� �̰��");
				}else{
					System.out.println("����� �̰��");
				}
			}
			if(you==1) {
				if(com==0) {
					System.out.println("����� �̰��");
				}else if(com == 1) {
					System.out.println("���º� �Դϴ�");
				}else{
					System.out.println("��ǻ�Ͱ� �̰��");
				}
			}
			if(you==2) {
				if(com==0) {
					System.out.println("��ǻ�Ͱ� �̰��");
				}else if(com == 1) {
					System.out.println("����� �̰��");
				}else{
					System.out.println("���º� �Դϴ�");
				}
			}
		}
		
		
		sc.close();
		
	}

}
