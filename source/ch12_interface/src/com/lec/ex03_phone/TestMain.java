package com.lec.ex03_phone;

public class TestMain {

	public static void main(String[] args) {
		AModel a = new AModel();
		BModel b = new BModel();
		CModel c = new CModel();
		IAcorporation[] phone = {a, b, c};
		for(IAcorporation p : phone) {
			System.out.println(p.getClass().getName());// 클래스 com.lec.ex03_phone.Xmodel이름 뿌려짐
			p.dmbReceive();
			p.lte();
			p.tvRemoteControl();
		}
	}

}
