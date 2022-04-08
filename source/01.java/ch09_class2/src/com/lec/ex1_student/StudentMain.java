package com.lec.ex1_student;

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
		int tot[] = new int[5]; // tot[0] = 국어 누적
		double avg[] = new double[5]; // 평균저장
		
		Student s1 = new Student("정우성", 90, 90, 90);
		Student s2 = new Student("김하늘", 81, 90, 91);
		Student s3 = new Student("황정민", 80, 80, 80);
		Student s4 = new Student("강동원", 80, 80, 81);
		Student s5 = new Student("유아인", 70, 70, 70); 
		
		Student [] student = {s1,s2,s3,s4,s5};
		String[] title = {"이름", "국어", "영어", "수학", "총점", "평균"};
		
		printLine('■', 65);
		System.out.println("\t\t\t      성적표");
		printLine(47);
		for(String t : title ) {
			System.out.print("\t"+t);
		}System.out.println();
		printLine(47);
		for(Student s : student) {
			s.print(); // 출력 후 누적
			tot[0] += s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg(); // tot[4] = (int)(tot[4]+s.getAvg());
		}
		for( int i = 0 ; i<avg.length ; i++) { //출력할 평균 계산
			avg[i] = (double)tot[i]/student.length;
		}
		printLine(47);
		System.out.print("\t총점\t");
		for (int t : tot) {
			System.out.print(t+"\t");
		}
		System.out.print("\n\t평균\t");
		for(double a : avg) {
			System.out.print(a+"\t");
		}
		System.out.println();
		printLine('■', 65);
	}

}
