package com.lec.homework;

public class Ex {

	public static void main(String[] args) {
		int kor = 90;
		int mat = 80;
		int eng = 78;
		
		int tot = kor+mat+eng;
		double avg = (double)tot/3;
		
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+avg);
		
	}

}
