package strategy3.modularization;
import strategy3.interfaces.GetStudentPay;
import strategy3.interfaces.JobStudy;
public class Student extends Person {
	private String ban;
	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t[��]"+ban);
	}
	@Override
	public String toString() {
		return super.toString() +"\t[��]"+ban;
	}
}