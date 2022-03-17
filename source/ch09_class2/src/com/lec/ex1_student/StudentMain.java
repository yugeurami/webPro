package com.lec.ex1_student;

public class StudentMain {
	
	private static void printLine(char a, int j) {
		for (int i = 1 ; i<j ; i++) {
			System.out.print(a);
		}
	}
	
	public static void main(String[] args) {
		Student s1 = new Student("���켺", 90, 90, 90);
		Student s2 = new Student("���ϴ�", 90, 90, 91);
		Student s3 = new Student("Ȳ����", 80, 80, 80);
		Student s4 = new Student("������", 80, 80, 81);
		Student s5 = new Student("������", 70, 70, 70); 
		
		Student [] student = {s1,s2,s3,s4,s5};
		String[] title = {"�̸�", "����", "����", "����", "����", "���"};
		
		printLine('��', 50);
		System.out.println("\t\t\t����ǥ");
		printLine('-', 40);
		for(String t : title ) {
			System.out.print('\t'+t);
		}
		for(Student s : student) {
			s.print();
		}
		printLine('-', 40);
		
	}

}
