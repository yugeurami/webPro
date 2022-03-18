package com.lec.condition;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {
		int kor, eng, mat;
		double avg;
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수는 : ");
		kor = sc.nextInt();
		System.out.print("영어 점수는 : ");
		eng = sc.nextInt();
		System.out.print("수학 점수는 : ");
		mat = sc.nextInt();
		
		int sum = kor + eng+ mat;
		avg = sum/3;
		
		if (kor>=avg) {
			System.out.printf("국어점수는 평균 %.2f점 이상이다.", avg);
		}else {
			System.out.printf("국어점수는 평균 %.2f점 미만이다.", avg);
		}if (eng>=avg) {
			System.out.printf("영어점수는 평균 %.2f점 이상이다.", avg);
		}else {
			System.out.printf("영어점수는 평균 %.2f점 미만이다.", avg);
		}if (mat>=avg) {
			System.out.printf("수학점수는 평균 %.2f점 이상이다.", avg);
		}else {
			System.out.println("수학점수는 평균"+ avg + "미만이다.");
		}
		
		sc.close();

	}

}
