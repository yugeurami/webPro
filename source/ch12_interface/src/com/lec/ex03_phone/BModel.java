package com.lec.ex03_phone;
//DMB송수신가능, LTE, TV리모콘 탑재
public class BModel implements IAcorporation {
	private String modelName = "B모델";
	
	public BModel() {
	
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 송수신 가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "은 LTE");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 TV리모콘 탑재");
	}

}
