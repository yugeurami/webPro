package com.lec.ex09_super;
// name, character / intro()
// Baby b = new Baby ("홍아가","이뻐");
// baby b1 = new Baby();
public class Baby extends Person{

	public Baby() {
		System.out.println("매개변수 없는 Baby 생성자");
	}

	public Baby(String name, String character) {
		super(name, character);//Person 클래스의 매개변수 없는 생성자를 실행하지 않음 
		//setName(name); setCharacter(character);
		System.out.println("매개변수 있는 Baby 생성자");
	}
	@Override
	public void intro() {
		System.out.print("응애 응애 난 아가야 ");
		super.intro(); // 내 클래스의 슈퍼단의 intro()
	}
	
}
