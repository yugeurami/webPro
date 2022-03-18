package com.lec.ex2_human.main;

import com.lec.ex2_human.*; // com.lec.ex2_human 패키지의 모든 class import
							//불필요한 package import 삭제 Ctrl + Shift + o

public class TestMain {

	public static void main(String[] args) {
		int i = 10;
		int j = 10;
		if(i==j) { // 기초데이터 다입에서의 같은 지 비교
			System.out.println("i와 j는 같다");
		}
		
		String name = "홍길동"; // String name = new String("홍길동")
		String name2 = "홍길동"; //String : 데이터 할당 전에 같은 데이터가 있는지 확인해보고 있으면 같은 주소를 불러옴
		if(name.equals(name2)) { // 객체와 객체가 같은 지 비교하는 방법
			System.out.println("name과 name2는 같다");
		}
		
		Woman hee1 = new Woman();
		Woman hee2 = new Woman();
//		hee1.method();
		if(hee1.equals(hee2)) { // equals : 내가 만든 적은 없지만 class생성 시 상속됨
			System.out.println("hee1과 hee2는 같다");
		}
		
		Man kang = new Man(22, 165, 60.1);
		Man kim = new Man(22, 180, 65.6);
		Man kim1; // 레퍼런스 변수(객체변수) 선언
		kim1 = kim;
		Man kim2 = new Man(22, 180, 65.6); // 현재 상태에서 equals로 비교하면 kim != kim2 주소가 다르면 다른 것으로 본다
		if(kim.equals(kim1)){
			System.out.println("kim과 kim1은 같다(같은 주소를 가리킨다)");
		}
		if(!kim.equals(kim2)){
			System.out.println("kim과 kim2는 다른 객체이다(다른 주소값이 있다)");
		}
		kang.setHeight(160);
		kang.setWeight(50.9);
		if(kang.calculateBMI() > 30 ) {
			System.out.println("건강하세요");
		}else {
			System.out.println("건강하겠네요");
		}
		
	}

}
