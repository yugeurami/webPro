package com.lec.ex4_member;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Member> member = new ArrayList<Member>();
		do {
			System.out.println("회원 가입을 진행하시겠습니까?(Y/N)");
			String chk = sc.next().trim();
			if(chk.equalsIgnoreCase("y")) {
				Member m = new Member();
				System.out.print("회원의 이름은? : ");
				m.setName(sc.next().trim());
				System.out.print("회원의 전화번호는? : ");
				m.setTel(sc.next().trim());
				System.out.print("회원의 주소는? : ");
				sc.nextLine();
				m.setAddress(sc.nextLine().trim());	
				member.add(m);
			}else if(chk.equalsIgnoreCase("n")){
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}while(true);
		if(member.size()==0) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			for(Member md : member) {
				System.out.println(md);
			}
		}
		sc.close();
	}
}
