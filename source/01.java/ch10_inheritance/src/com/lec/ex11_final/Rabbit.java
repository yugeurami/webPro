package com.lec.ex11_final;
//Animal로 부터 speed, running(), stop() 상속받음
public final class Rabbit extends Animal {
	@Override
	public void running() {
		setSpeed(getSpeed()+30);
		System.out.println("마구 뛰어요. 현재 속도 : "+getSpeed());
	}
}
