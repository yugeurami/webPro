package com.lec.loop;
//�� ������ �����������ϴ� ���α׷��� ����
import java.util.Scanner;

public class Quiz05while {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com;
		
		do {
			System.out.println("����(0),����(1),��(2) �� �ϳ��� �����ϼ��� : ");
			you = sc.nextInt(); 
			com = (int)(Math.random()*3);
			if(you == 0) {
				System.out.print("����� ���� \t");
			}else if (you == 1) {
				System.out.print("����� ���� \t");
			}else if(you == 2) {
				System.out.print("����� ���ڱ� \t");
			}else {
				System.out.println("����� �߸� �¾��. ����");
				you = 3;
				break;
			}
			if(you !=3) {
				String msg = (com == 0)? "��ǻ�ʹ� ����" : (com == 1)? "��ǻ�ʹ� ����" : "��ǻ�ʹ� ���ڱ�";
				System.out.println(msg);
				
				if ((you+1)%3==com) {
					System.out.println("����� �����ϴ�");
					break;
				} else if(you==com) {
					System.out.println("���º��Դϴ�");
				} else {
					System.out.println("����� �̰���ϴ�");
				} 
			} 
		} while(true);
		System.out.println("�ȳ��� ������");	
		sc.close();

	}

}
