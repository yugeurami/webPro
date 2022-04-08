package com.lec.ex1_awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02Login2 extends Frame {
	private Panel		panel;
	private Label 		lbl1;
	private TextField 	txtId;
	private Label 		lbl2;
	private TextField 	txtPw;
	private Button 		btnLogin;
	public Ex02Login2(String title) { // Frame에 컴포넌트 추가하고 화면 보이게 -> 이벤트
		super(title);
		panel = new Panel(); // 패널의 기본 레이아웃 : FlowLayout
		//setLayout(new GridLayout(2,2));
		
		lbl1 = new Label("I      D");
		txtId = new TextField("ID", 20);
		lbl2 = new Label("PASSWORD");
		txtPw = new TextField(20);
		txtPw.setEchoChar('*');
		btnLogin = new Button("LOGIN");
		
		panel.add(lbl1);
		panel.add(txtId);
		panel.add(lbl2);
		panel.add(txtPw);
		panel.setPreferredSize(new Dimension(280, 50));
		add(panel, BorderLayout.NORTH);
		add(btnLogin, BorderLayout.SOUTH);
		setSize(new Dimension(300, 150));
		setLocation(200, 100);
		setVisible(true);
		setResizable(false); // 사용자가 size 조정 불가
		
		// X 클릭 시 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);	// 안보이게
				dispose();			// 자원 해체
				System.exit(0);		// 강제 종료
			}
		});
		
	}
	public Ex02Login2() {
		this("");
	}
	public static void main(String[] args) {
		new Ex02Login2("Login");
	}
}
