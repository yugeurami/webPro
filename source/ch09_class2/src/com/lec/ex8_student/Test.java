package com.lec.ex8_student;
// Student.java => ex1_student, ex8_student 패키지
import com.lec.ex1_student.Student;
public class Test {

	public static void main(String[] args) {
		Student s1 = new Student("홍", 90, 90, 90);
		s1.print();
		com.lec.ex8_student.Student s8 = new com.lec.ex8_student.Student("홍8", 88, 88, 88);
		s8.print();

	}

}
