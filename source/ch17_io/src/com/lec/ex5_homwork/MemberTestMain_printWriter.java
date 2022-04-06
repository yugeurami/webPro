package com.lec.ex5_homwork;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class MemberTestMain_printWriter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Writer writer = null;
		ArrayList<Member> members = new ArrayList<>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String now = sdf.format(date);
		do {
			Member member = new Member();
			System.out.println("회원 가입을 진행하시겠습니까?(Y/N)");
			String chk = sc.next().trim();
			if(chk.equalsIgnoreCase("y")) {
				System.out.print("이름을 입력해주세요 : ");
				member.setName(sc.next().trim());
				System.out.print("전화번호를 입력해주세요 : ");
				member.setPhone(sc.next().trim());
				do {
					System.out.print("생년월일을 입력해주세요(1900-00-00) : ");
					member.setBirth(sc.next().trim());
					if(member.getBirth().length()!=10 ||member.getBirth().charAt(4)!='-' || member.getBirth().charAt(7)!='-') {
						System.out.println("생년월일은 (1900-00-00) 양식으로 입력해주세요");
					} else {
						break;
					}
				}while(true);
				if(member.getBirth().substring(5).equals(now)) {
					System.out.println("생일축하합니다");
				}
				System.out.print("회원의 주소는? : ");
				sc.nextLine();
				member.setAddress(sc.nextLine().trim());	
				members.add(member);
			}else if(chk.equalsIgnoreCase("n")){
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}while(true);
		if(members.size()==0) {
			System.out.println("회원 정보가 없습니다.");
		} else {
			for(Member md : members) {
				System.out.print(md);
			}
			System.out.println("이하"+members.size()+"명 가입");
		}
		try {
			writer = new FileWriter("D:\\yujin\\webPro\\source\\ch17_io\\src\\com\\lec\\ex5_homwork/member.txt");
			String msg = "이하"+members.size()+"명 가입";
			for(Member md : members) {
				String msg2 = md.toString();
				writer.write(msg2);
			}
			writer.write(msg);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		sc.close();
	}
}
