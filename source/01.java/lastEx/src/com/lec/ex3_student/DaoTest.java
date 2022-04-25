package com.lec.ex3_student;

public class DaoTest {

	public static void main(String[] args) {
		StudentDao dao = StudentDao.getInstance();
		StudentDto dto = dao.selectSno(2022001);
		System.out.println("[학번검색]");
		if(dto.getSno()!=0) {
			System.out.println(dto);
		} else {
			System.out.println("해당 학번의 학생은 존재하지 않습니다.");
		}
		System.out.println("[학생입력]");
	}

}
