package com.lec.ex3_math;

import java.util.Random;

public class Ex05_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();
		for(int idx = 0 ; idx<lotto.length ; idx++) {
			//lotto[idx] = random.nextInt(45)+1;
			int temp = random.nextInt(45)+1; // 뽑은 난수를 임시 변수에 저장하고
			boolean ok = true; // 뽑은 난수가 중복이 아닐 경우 true/중복일 경우 false
			for(int i = 0 ; i<idx ; i++) {
				if(temp==lotto[i]) { //뽑은 난수가 중복이니 다시 뽑
					idx --;
					ok = false;
					break;
				}
			} // 발생된 난수가 이전 앞방에 저장되었는지 확인(중복된 난수인지)
			if(ok) {
				lotto[idx] = temp;
			}
		}
		for(int i = 0 ; i<lotto.length ; i++) {
			for (int j = i+1 ; j<lotto.length ; j++) {
				if(lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		} // 오름차순 정렬
		for(int l : lotto) {
			System.out.print(l+"\t");
		}
	}
}
