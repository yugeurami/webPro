package com.lec.ex6_member;
//id, pw, name, email, address, birth, gender
/*
 * �޼ҵ� : �����̵� = aaa
         �̸� = ȫ�浿
         �̸��� = hong@company.com
         �ּ� = ���� ������
         ���� = 2000-01-01
         ���� = �� ��(��ü ����)�� return�ϴ� infoString() �޼ҵ�

 */
public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String address;
	private String birth;
	private String gender;
	
	public Member() {	}
	public Member(String id, String pw, String name, String email, String address, String birth, String gender) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
	}
	public String infoString() {
		return String.format("���̵� = %s\n�̸� = %s\n�̸��� = %s\n�ּ� = %s\n���� = %s\n���� = %s", id, name, email, address, birth, gender);
	}
	
}
