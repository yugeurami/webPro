package strategy3.modularization;

public class TestMain {
	public static void main(String[] args) {
		Student st1 = new Student("30301", "강학생", "국비자바");
		Student st2 = new Student("30302", "강공부", "자바단기");
		Lecturer l1 = new Lecturer("J01", "홍강의", "빅데이터");
		Lecturer l2 = new Lecturer("J02", "김수업", "웹프로그래밍");
		Staff s1  = new Staff("A01", "신일해", "관ㄹ");
		Person[] person = {st1, st2, l1, l2, s1};
		for(Person p : person)
			p.job();
		System.out.println("월말엔 다 지급할 것 지급");
		for(Person p : person)
			p.get();
		System.out.println("궁금하면 프린트");
		for(Person p : person)
			System.out.println(p);
//			p.print();
			
	}
}