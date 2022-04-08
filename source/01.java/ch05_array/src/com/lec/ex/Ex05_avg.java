package com.lec.ex;
import java.util.Scanner;
//사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아, 평균키를 출력
public class Ex05_avg {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] arrName = {"영희","철수","길동","영수","말자"};
		int[] arrHeight = new int[arrName.length];
		int totalHeight = 0; // 입력받은 키 누적 변수
		for(int idx =0 ; idx<arrName.length ; idx++) {
			System.out.print(arrName[idx]+"의 키는 : ");
			arrHeight[idx] = scanner.nextInt();
			totalHeight += arrHeight[idx];
		}
		System.out.println("평균키는 "+(double)totalHeight/arrName.length);
		scanner.close();
	}

}
