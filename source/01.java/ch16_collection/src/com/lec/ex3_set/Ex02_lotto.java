package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;

public class Ex02_lotto {

	public static void main(String[] args) {
		HashSet<Integer> lotto = new HashSet<Integer>();
		//TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random random = new Random();
		int cnt = 0; 
		while(lotto.size()<6) {
			cnt++;
			lotto.add(random.nextInt(45)+1); //1~45사이의 정수 난수 add
		}
		System.out.println(cnt + "번 숫자 뽑아 나온 로또 수들 : "+lotto);
	}

}
