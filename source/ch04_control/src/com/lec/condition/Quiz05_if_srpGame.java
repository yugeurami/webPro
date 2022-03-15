package com.lec.condition;

import java.util.Scanner;
// 0 <= Math.random() < 1
// 0 <= Math.random()*3 < 3
// (int)(Math.random()*3) : 0,1,2
public class Quiz05_if_srpGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com;
		com = (int)(Math.random()*3);
		System.out.println("가위(0),바위(1),보(2) 중 하나를 선택하세요 : ");
		you = sc.nextInt(); // 정수를 입력 받은
		if(you == 0) {
			System.out.print("당신은 가위 \t");
		}else if (you == 1) {
			System.out.print("당신은 바위 \t");
		}else if(you == 2) {
			System.out.print("당신은 보자기 \t");
		}else {
			System.out.println("당신은 잘못 냈어요. 바이");
			you = 3;//끝내기 위한 조건
		}
		if(you !=3) {//컴퓨터가 낸 것과 승패 출력
			String msg = (com == 0)? "컴퓨터는 가위" : (com == 1)? "컴퓨터는 바위" : "컴퓨터는 보자기";
			System.out.println(msg);
			if(you==0) {
				if(com==0) {
					System.out.println("무승부 입니다");
				}else if(com == 1) {
					System.out.println("컴퓨터가 이겼다");
				}else{
					System.out.println("당신이 이겼다");
				}
			}
			if(you==1) {
				if(com==0) {
					System.out.println("당신이 이겼다");
				}else if(com == 1) {
					System.out.println("무승부 입니다");
				}else{
					System.out.println("컴퓨터가 이겼다");
				}
			}
			if(you==2) {
				if(com==0) {
					System.out.println("컴퓨터가 이겼다");
				}else if(com == 1) {
					System.out.println("당신이 이겼다");
				}else{
					System.out.println("무승부 입니다");
				}
			}
		}
		
		
		sc.close();
		
	}

}
