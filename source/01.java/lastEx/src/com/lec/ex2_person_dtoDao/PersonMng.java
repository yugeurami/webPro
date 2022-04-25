package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> dtos;
		do {
			System.out.println("어떤 서비스를 이용하시겠습니까?");
			System.out.println("1번은 데이터 입력");
			System.out.println("2번은 직업별 등수 조회");
			System.out.println("3번은 모든 사람의 등수 조회");
			System.out.println("그 외의 문자를 입력하시면 종료합니다");
			fn = sc.next();
			switch (fn) {
			case "1": // 이름 직업명 국영수 입력
				System.out.print("입력할 이름은? : ");
				String pname = sc.next();
				System.out.print("입력할 직업은? : ");
				String jname = sc.next();
				System.out.print("국어 점수는? : ");
				int kor = sc.nextInt();
				System.out.print("영어 점수는? : ");
				int eng = sc.nextInt();
				System.out.print("수학 점수는? : ");
				int mat = sc.nextInt();
				int result = dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				System.out.println(result==PersonDao.SUCCESS ? "입력성공" : "입력실패");
				break;
			case "2":
				System.out.print("조회할 직업명은? : ");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if(dtos.isEmpty()) {
					System.out.println("해당 직업의 사람이 없습니다");
				} else {
					System.out.println("rank\t이름\t\t직업명\t국어\t영어\t수학\t합계");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3":
				System.out.println("전체조회");
				dtos = dao.selectAll();
				if(dtos.size()==0) {
					System.out.println("등록된 사람이 없습니다");
				} else {
					System.out.println("rank\t이름\t\t직업명\t국어\t영어\t수학\t합계");
					for(PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			}
		}while(fn.equals("1")||fn.equals("2")||fn.equals("3"));
		sc.close();
		System.out.println("종료합니다");
	}

}
