package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCrimonal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		park.makeSpaghhetti();
		
		IChef chefPark = new Actor("박요리");
//		chefPark.canCatchCriminal() 불가
		chefPark.makePizza();
		chefPark.makeSpaghhetti();
		
		IFireFighter firePark = new Actor("박소방");
//		firePark.makePizza(); 불가
		firePark.outFire();
		firePark.saveMan();
		
		IPolice policePark = new Actor("박경찰");
//		policePark.outFire(); 불가
		policePark.canCatchCrimonal();
		policePark.canSearch();
	}
}
