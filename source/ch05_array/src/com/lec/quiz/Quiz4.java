package com.lec.quiz;
//�Ž����� 2680�� 500, 100, 50, 10¥�� �������� �� ��, ��� �־�� �ϳ�?
public class Quiz4 {

	public static void main(String[] args) {
		int money = 2680;
		int[] coin = {500, 100, 50, 10};
		for(int i = 0 ; i<coin.length ; i++) {
			System.out.print(money+"���� ");
			System.out.printf("%d��¥�� %d��, ", coin[i], money/coin[i]);
			money %= coin[i];
		}

	}

}
