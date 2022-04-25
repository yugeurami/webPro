package com.lec.ex2_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {

	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance();
		PersonDto dto = new PersonDto("김길순", "배우", 60, 80, 70);
		int result = dao.insertPerson(dto);
		System.out.println(result == PersonDao.SUCCESS ? "입력성공" : "입력실패");
		ArrayList<PersonDto> dtos = dao.selectJname("배우");
		if(!dtos.isEmpty()) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		}else {
			System.out.println("해당직업의 사람이 등록되지 않았습니다");
		}
		System.out.println("---------------------------------------------------------------------------");
		dtos = dao.selectAll();
		if(dtos.size()!=0) {
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
		} else {
			System.out.println("등록된 사람이 없습니다");
		}
		Vector<String> jnames = dao.jnameList();
		System.out.println(jnames);
	}

}
