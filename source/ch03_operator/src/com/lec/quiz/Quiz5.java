package com.lec.quiz;

public class Quiz5 {

	public static void main(String[] args) {
		int kor = 75;
		int eng = 80;
		int mat = 30;
		
		int tot = kor + eng + mat;
		double agv = tot/3.0;
		
		System.out.println("±¹¾î\t ¿µ¾î\t ¼öÇÐ\t ÃÑÁ¡\t Æò±Õ");
		System.out.printf("%d\t %d\t %d\t %d\t %.2f", kor, eng, mat, tot, agv);

	}

}
