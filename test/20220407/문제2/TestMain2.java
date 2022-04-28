package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {

	public static void main(String[] args) {
		String name, phone, address;
		HashMap <String, Customer> customers = new HashMap<>();
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
				if(customers.get(phone)!=null) {
					System.out.println("같은 번호가 있어서 회원가입이 불가능합니다.");
					continue;
				}
				System.out.print("주소를 입력해주세요 : ");
				scanner.nextLine();
				address = scanner.nextLine().trim();
				customers.put(phone ,new Customer(name, phone, address));
			}
		}
		if(customers.size()==0) {
			System.out.println("회원 정보가 없습니다.");
		}else {
			Iterator<String> iterator = customers.keySet().iterator();
			while(iterator.hasNext()) {
				String key = iterator.next(); 
				System.out.println(customers.get(key));
			}
			System.out.println("\t\t. . . . .");
		}
		scanner.close();
	}

}
