package strategy3.modularization;
import strategy3.interfaces.IGet;
import strategy3.interfaces.IJob;
public abstract class Person {
	private String id;
	private String name;
	private IJob job;
	private IGet get;
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public void job() {
		job.job();
	}
	public void get() {
		get.get();
	}
//	public abstract void print();
	public void print() {
		System.out.print("[id]" + id + "\t[name]" + name);
	}
	@Override
	public String toString() {
		return "id=" + id + "\t name=" + name + "\t ";
	}
	public void setJob(IJob job) {this.job = job;}
	public void setGet(IGet get) {this.get = get;}
}


