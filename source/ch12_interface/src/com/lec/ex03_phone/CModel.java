package com.lec.ex03_phone;
//DMB송수신불가, LTE, TV리모콘 미탑재
public class CModel implements IAcorporation {
	private String modelName = "C모델";
	
	public CModel() {	
		
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "은 DMB 송수신 불가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "은 LTE");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "은 TV리모콘 미탑재");
	}

}
