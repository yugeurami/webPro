package strategy3.modularization;
import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobLec;
public class Lecturer extends Person {
	private String subject;

	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t[���ǰ���]"+subject);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t[���ǰ���]"+subject;
	}
}