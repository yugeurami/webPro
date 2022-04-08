package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class Ex01MyFrame extends Frame {
	private Button btn;
	private Button btn1;
	public Ex01MyFrame(String title) {
		super(title);
		//버튼 2개를 추가한 프레임
		btn = new Button("button");
		btn1 = new Button("just button");
		add(btn, BorderLayout.NORTH);
		add(btn1, BorderLayout.CENTER);
		//pack(); // 최소한의 사이즈로
		setSize(300,200);
		setVisible(true);
		setLocation(100, 50);
		
		// 3초 후 자동 창닫고 실행종료
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {	}
		setVisible(false); // 화면 안보이게
		dispose(); // 자원 해제
		System.exit(0); // 강제 종료
	}
	public static void main(String[] args) {
		new Ex01MyFrame("first GUI");
	}
}
