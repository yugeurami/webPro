package com.lec.ex3_student;

import java.util.ArrayList;

public class DaoTest {

	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		StudentDto dto = dao.selectSno(2022);
		System.out.println("[학번검색]");
		if(dto.getSno()!=0) {
			System.out.println(dto);
		} else {
			System.out.println(dto.getSno()+"은 유효하지 않은 학번입니다");
		}
		System.out.println("[이름 검색]");
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		dtos = dao.selectSname("이길동");
		if(dtos.isEmpty()) {
			System.out.println("해당 이름의 학생이 없습니다");
		} else{
			for(StudentDto d: dtos) {
				System.out.println(d);
			}
		}
		System.out.println("[학과 검색]");
		dtos = dao.selectMname("인공지능학");
		if(dtos.isEmpty()) {
			System.out.println("해당 학과의 학생이 없습니다");
		} else{
			for(StudentDto d: dtos) {
				System.out.println(d);
			}
		}
		System.out.println("[학생 입력]");
		dto = new StudentDto("김유진", "국어국문학", 80);
		int result = dao.insertStudent(dto);
		System.out.println(result == dao.SUCCESS ? "입력성공" : "입력실패");
		
		System.out.println("[학생 수정]");
		dto = new StudentDto(2022003, "김유진", "국어국문학", 90);
		result = dao.updateStudent(dto);
		System.out.println(result == dao.SUCCESS ? "수정성공" : "수정실패");
		
		System.out.println("[학생 전체 출력]");
		dtos = dao.selectAll();
		if(dtos.isEmpty()) {
			System.out.println("학생이 없습니다");
		} else{
			for(StudentDto d: dtos) {
				System.out.println(d);
			}
		}
		System.out.println("[재적자 출력]");
		dtos = dao.selectReg();
		if(dtos.isEmpty()) {
			System.out.println("재적된 학생이 없습니다");
		} else{
			for(StudentDto d: dtos) {
				System.out.println(d);
			}
		}
		System.out.println("[재적 처리]");
		dto = new StudentDto(2022003, "김유진", "국어국문학", 90);
		result = dao.updateReg(dto);
		System.out.println(result == dao.SUCCESS ? "재적처리성공": "실패");
	}
}
