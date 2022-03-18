package com.lec.ex8_student;

public class StudentMain {
	private static void printLine(int j) {
		System.out.print("\t");
		for (int i = 1 ; i<j ; i++) {
			System.out.print('-');
		}System.out.println();
	}
	private static void printLine(char a, int j) {
		for (int i = 1 ; i<j ; i++) {
			System.out.print(a);
		}System.out.println();
	}
	
	public static void main(String[] args) {
		int tot[] = new int[5]; 
		double avg[] = new double[5]; 
		
		Student s1 = new Student("정우성", 90, 80, 95);
		Student s2 = new Student("김하늘", 100, 80, 95);
		Student s3 = new Student("황정민", 95, 80, 90);
		Student s4 = new Student("강동원", 95, 90, 99);
		Student s5 = new Student("유아인", 90, 90, 90); 
		
		Student [] student = {s1,s2,s3,s4,s5};
		String[] title = {"번호", "이름", "국어", "영어", "수학", "총점", "평균"};
		
		printLine('■', 80);
		System.out.println("\t\t\t\t성적표");
		printLine(60);
		for(String t : title ) {
			System.out.print("\t"+t);
		}System.out.println();
		printLine(60);
		for(Student s : student) {
			s.print(); 
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg(); 
		}
		for(int i = 0 ; i<avg.length ; i++) { 
//			avg[i] = tot[i]/student.length; // 버림
//			avg[i] = (double)tot[i]/student.length;
//			avg[i] = (int)((double)tot[i]/student.length+0.5); //반올림
			avg[i] = (int)Math.round((double)tot[i]/student.length); //반올림
		}
		printLine(60);
		System.out.print("\t\t총점\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		}
		System.out.print("\n\t\t평균\t");
		for(double a : avg) {
			System.out.print(a+"\t");
		}
		System.out.println();
		printLine('■', 80);
	}
}
