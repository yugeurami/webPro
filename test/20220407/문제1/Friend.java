package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private  String name;
	private String phone;
	private String address;
	private Date birthday;
	
	public Friend() {
	}

	public Friend(String name, String address, String phone,  Date birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "이름 : "+name+ "\n전화번호 : "+phone+"\n주소 : "+address+"\n생일 : "+sdf.format(birthday);
	}

	public String getAddress() {
		return address;
	}
	
}
