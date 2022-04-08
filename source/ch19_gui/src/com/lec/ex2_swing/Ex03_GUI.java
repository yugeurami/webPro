package com.lec.ex2_swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Ex03_GUI extends JFrame implements ActionListener {
	//컴포넌트 객체 변수 선언 (ArrayList 변수, file io를 위한 stream, db 접속 관련 변수도 여기에서)
	private Container 	contenPane; // 컨테이너 얻어올 변수
	private JPanel 		jp; //이름, 전화, 나이 받을 6개의ㅣ 컴포넌트를 gridLayout으로 add
	private JTextField	txtName, txtTel, txtAge;
	private ImageIcon	icon;
	private JButton 	btnOut;
	private JTextArea	jta;
	private JScrollPane	scrollbar;
	private int			cnt; // 몇명 입력했는지 저장
	
	// 생성자 : 컨테이너 얻어옴 -> layout setting -> 컴포넌트 객체 생성 후 add -> 이벤트 추가
	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp 			= new JPanel(new GridLayout(3,2)); // 패널의 기본 레이아웃은 FlowLayout
		txtName 	= new JTextField();
		txtTel		= new JTextField();
		txtAge		= new JTextField();
		icon		= new ImageIcon("icon/output.png");
		btnOut		= new JButton("Output", icon);
		jta			= new JTextArea(5,30); // 5행 30열 textArea
		scrollbar	= new JScrollPane(jta);	
		jp.add(new JLabel("NAME", (int)CENTER_ALIGNMENT));
		jp.add(txtName);
		jp.add(new JLabel("TEL", (int)CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("AGE", (int)CENTER_ALIGNMENT));
		jp.add(txtAge);
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(btnOut, BorderLayout.CENTER);
		contenPane.add(scrollbar, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(500, 400, 400, 300); // 로케이션, 사이즈
		
		// 이벤트 추가
		btnOut.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직
		if(e.getSource() == btnOut) {
			// txt에 입력된 값을 jta에 출력
			String name = txtName.getText().trim();
			String tel = txtTel.getText().trim();
			if(name.equals("")) {
				System.out.println("이름은 필수 입력 사항입니다");
				return;
			}
			if(tel.equals("")) {
				System.out.println("전화번호는 필수 입력 사항입니다");
				return;
			}
			if(	tel.indexOf("-") == tel.lastIndexOf("-") || 
				tel.indexOf("-")<2 ||
				tel.lastIndexOf("-")>10) {
				System.out.println("전화번호 형식을 확인해주세요");
				return;
			}
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if(age<0 || age>150) {
					System.out.println("유효하지 않은 나이를 입력하셨습니다");
					age = 0;
				}
			} catch (Exception e2) {
				System.out.println("유효하지 않은 나이를 입력하셨습니다");
				age = 0;
			}
			System.out.println(++cnt + "명 입력됨");
			if(cnt==1) {
				jta.setText("이름\t전화\t\t나이\n");
			}
			jta.append(name+"\t"+tel+"\t\t"+age+"\n"); // 한명 add한 것을 jta출력
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
			
		} 
	}
	public static void main(String[] args) {
		new Ex03_GUI("last Ex");
	}
}
