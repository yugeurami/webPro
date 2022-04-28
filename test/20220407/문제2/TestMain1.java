package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		String name, phone, address;
		OutputStream os = null;
		ArrayList<Customer> customers = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("회원가입을 진행합니다 (진행을 원하시지 않으시면 n을 입력해주세요)");
			String YorN = scanner.nextLine().trim();
			if(YorN.equalsIgnoreCase("n")) {
				break;
			}else {
				System.out.print("이름을 입력해주세요 : ");
				name = scanner.next().trim();
				System.out.print("핸드폰 번호를 입력해주세요 : ");
				phone = scanner.next().trim();
				for(Customer c : customers) {
					if(c.getPhone().equals(phone)) {
						System.out.println("같은 번호가 있어서 회원가입이 불가능합니다.");
						continue;
					}
				}
				System.out.print("주소를 입력해주세요 : ");
				scanner.nextLine();
				address = scanner.nextLine().trim();
				customers.add(new Customer(name, phone, address));
			}
		}
		if(customers.isEmpty()) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			for(Customer c : customers) {
				System.out.println(c);
			}
			System.out.println("\t\t. . . . .");
		}
		try {
			os = new FileOutputStream("src/test/customer.txt");
			for(int i = 0 ; i<customers.size() ; i++){
				String msg = customers.get(i).toString()+"\n";
				byte[] bs = msg.getBytes();
				os.write(bs);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		scanner.close();
	}
}
