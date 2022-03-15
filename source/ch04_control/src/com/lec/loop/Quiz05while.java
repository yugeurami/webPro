package com.lec.loop;
//질 때까지 가위바위보하는 프로그램을 구현
import java.util.Scanner;

public class Quiz05while {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int you, com;
		
		do {
			System.out.println("가위(0),바위(1),보(2) 중 하나를 선택하세요 : ");
			you = sc.nextInt(); 
			com = (int)(Math.random()*3);
			if(you == 0) {
				System.out.print("당신은 가위 \t");
			}else if (you == 1) {
				System.out.print("당신은 바위 \t");
			}else if(you == 2) {
				System.out.print("당신은 보자기 \t");
			}else {
				System.out.println("당신은 잘못 냈어요. 바이");
				you = 3;
				break;
			}
			if(you !=3) {
				String msg = (com == 0)? "컴퓨터는 가위" : (com == 1)? "컴퓨터는 바위" : "컴퓨터는 보자기";
				System.out.println(msg);
				
				if ((you+1)%3==com) {
					System.out.println("당신은 졌습니다");
					break;
				} else if(you==com) {
					System.out.println("무승부입니다");
				} else {
					System.out.println("당신이 이겼습니다");
				} 
			} 
		} while(true);
		System.out.println("안녕히 가세요");	
		sc.close();

	}

}
