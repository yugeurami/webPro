package com.lec.condition;

import java.util.Scanner;
// 0 <= Math.random() < 1
// 0 <= Math.random()*3 < 3
// (int)(Math.random()*3) : 0,1,2
public class Quiz05_if_srpGame2 {

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
			// ����� ���� 3���� : ���� �̰�� ����
			if ((you+1)%3==com) {
				System.out.println("����� �����ϴ�");
			} else if(you==com) {
				System.out.println("���º��Դϴ�");
			} else {
				System.out.println("����� �̰���ϴ�");
			} // if �������
			
		}
		
		
		sc.close();
		
	}

}
