package strategy3.modularization;
import strategy3.interfaces.GetSalary;
import strategy3.interfaces.JobMng;
public class Staff extends Person {
	private String part;
	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t[�μ�]" + part);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +"\t[�μ�]" + part;
	}
}