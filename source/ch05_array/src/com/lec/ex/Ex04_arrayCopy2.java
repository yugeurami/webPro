package com.lec.ex;
//API�� �̿��� �迭 ���� System.arraycopy(����,��������idx,���纻�迭,���纻����idx,�氹��)
public class Ex04_arrayCopy2 {

	public static void main(String[] args) {
		int[] score = {100,10,20,30,40};
		int[] s = new int[score.length];
		System.arraycopy(score, 0, s, 0, score.length);
		s[0] = 99;
		for(int idx = 0 ; idx<score.length ; idx++) {
			System.out.printf("score[%d]=%d\t s[%d]=%d\n", idx, score[idx], idx ,s[idx]);
		}

	}

}
