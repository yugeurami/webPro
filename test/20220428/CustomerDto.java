package quiz1;

public class CustomerDto {
	private int cno;
	private String cname;
	private String ctel;
	private int cpoint;
	
	public CustomerDto() {}
	
	//입력용
	public CustomerDto(int cno, String cname, String ctel) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.ctel = ctel;
	}
	
	//출력용
	public CustomerDto(String cname, String ctel, int cpoint) {
		super();
		this.cname = cname;
		this.ctel = ctel;
		this.cpoint = cpoint;
	}

	@Override
	public String toString() {
		return cname + "\t" + ctel + "\t\t" + cpoint + "\n";
	}

	public int getCno() {
		return cno;
	}

	public String getCname() {
		return cname;
	}

	public String getCtel() {
		return ctel;
	}

	public int getCpoint() {
		return cpoint;
	}
	
}
