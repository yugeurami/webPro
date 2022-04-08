package com.lec.ex5_momchild;
// Child first = new Child("첫째");
public class Child {
	private String name;
	static MomPouch momPouch; // 하나만 생성됨, 여러 child객체를 생성해도 하나를 공유
	public Child() {}
	public Child(String name) {
		this.name = name;
		momPouch = new MomPouch();
	}
	public void takeMoney(int money) {
		if(momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name+"가"+money+"원 가져가서 엄마 지갑에"+momPouch.money+"원 있음");
		}else {
			System.out.println(name+"가 돈을 못 받음. 현재 엄마 지갑에는"+momPouch.money+"원밖에 없음");
		}	
	}
}
