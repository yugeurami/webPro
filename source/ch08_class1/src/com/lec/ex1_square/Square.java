// ��Ű����, Ŭ������, ������, �������Լ�(�����ε�), �޼ҵ�, setter&getter
package com.lec.ex1_square;

public class Square {
	private int side;
	// �������Լ� ��ü�� ���� ���� JVM�� ����Ʈ ������(�ƹ� �͵� ���� �ʴ� �Ű����� ���� ������) �������
	public Square() { //�������Լ� : return type�� ����, Ŭ������� ���� �Լ�
		System.out.println("�Ű����� ���� ������ �Լ� ȣ���");
	}
	public Square(int side) { // �Ű����� �ִ� ������ �Լ��� �뵵 : ������ �ʱ�ȭ
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ �Լ� ȣ���. side �ʱ�ȭ");
	}
	public int area() {
		return side*side;
	}
	public void setSide(int side) {
		this.side = side;
	}
	public int getSide() {
		return side;
	}
}
