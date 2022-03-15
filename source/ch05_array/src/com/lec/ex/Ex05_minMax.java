package com.lec.ex;
import java.util.Scanner;
//사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아, 평균키를 출력
//최장신 이름과 키, 최단신 이름과 키 출력
public class Ex05_minMax {
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
		scanner.close();//이 이후에는 scanner 사용불가능
		//최장신 이름과 키, 최단신 이름과 키 출력
		int minHeight = 999, minIdx = 0; //최단신 키와 index(위치)
		int maxHeight = 0, maxIdx = 0;   //최장신 키와 index(위치)
		for(int i = 0 ; i<arrName.length ; i++) {
			if(arrHeight[i]<minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			} // if 최단신 키와 최단신 index찾기
		}
		for(int i = 0 ; i<arrName.length ; i++) {
			if(arrHeight[i]>maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
			} // if 최장신 키와 최장신 index찾기
		}
		System.out.printf("최장신 학생은 %s, 키는 %dcm \n", arrName[maxIdx], maxHeight);
		System.out.printf("최단신 학생은 %s, 키는 %dcm", arrName[minIdx], minHeight);
	}
}
