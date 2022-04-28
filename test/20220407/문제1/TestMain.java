package test;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		HashMap<String, Friend> hashMap = new HashMap<String, Friend>();
		Friend[] friends = {new Friend("홍길동", "서울시 용산구", "010-9999-1234", new Date(120, 4, 22)),
							new Friend("김길동", "용인시 기흥구", "010-9999-4444", new Date(120, 6, 20))};
		for(Friend f : friends) {
			hashMap.put(f.getAddress(), f);			
		}
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("검색할 주소 앞 글자 2자리 (단, 종료를 원하시면 x를 입력하시오) : ");
			String ad = scanner.next().trim();
			boolean chk = false;
			if(ad.length()==2) {
				for(Friend f : friends) {
					String fad = f.getAddress().substring(0,2);
					if(ad.equals(fad)){
						System.out.println(f);
						chk = true;
					}
				}
				if(chk == false) {
					System.out.println("해당 전화번호의 친구는 없습니다");
				}
			} else if(ad.equalsIgnoreCase("x")){
				break;
			}else {
				System.out.println("검색할 주소 앞 글자 2자리를 입력해주세요");
				continue;
			} 
		}
		scanner.close();
	} 

}
