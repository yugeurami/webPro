package com.lec.ex2_human.main;

import com.lec.ex2_human.*; // com.lec.ex2_human ��Ű���� ��� class import
							//���ʿ��� package import ���� Ctrl + Shift + o

public class TestMain {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i==j) { // ���ʵ����� ���Կ����� ���� �� ��
			System.out.println("i�� j�� ����");
		}
		
		String name = "ȫ�浿"; // String name = new String("ȫ�浿")
		String name2 = "ȫ�浿"; //String : ������ �Ҵ� ���� ���� �����Ͱ� �ִ��� Ȯ���غ��� ������ ���� �ּҸ� �ҷ���
		if(name.equals(name2)) { // ��ü�� ��ü�� ���� �� ���ϴ� ���
			System.out.println("name�� name2�� ����");
		}
		
		Woman hee1 = new Woman();
		Woman hee2 = new Woman();
//		hee1.method();
		if(hee1.equals(hee2)) { // equals : ���� ���� ���� ������ class���� �� ��ӵ�
			System.out.println("hee1�� hee2�� ����");
		}
		
		Man kang = new Man(22, 165, 60.1);
		Man kim = new Man(22, 180, 65.6);
		Man kim1; // ���۷��� ����(��ü����) ����
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6); // ���� ���¿��� equals�� ���ϸ� kim != kim2 �ּҰ� �ٸ��� �ٸ� ������ ����
		if(kim.equals(kim1)){
			System.out.println("kim�� kim1�� ����(���� �ּҸ� ����Ų��)");
		}
		if(!kim.equals(kim2)){
			System.out.println("kim�� kim2�� �ٸ� ��ü�̴�(�ٸ� �ּҰ��� �ִ�)");
		}
		kang.setHeight(160);
		kang.setWeight(50.9);
		if(kang.calculateBMI() > 30 ) {
			System.out.println("�ǰ��ϼ���");
		}else {
			System.out.println("�ǰ��ϰڳ׿�");
		}
		
	}

}
