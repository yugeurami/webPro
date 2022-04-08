package com.lec.ex2_swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex01_Thursday extends JFrame implements ActionListener {
	private JPanel panel; // 받아온 컨테이너를 저장
	//private Container contenPane; //받아온 컨테이너를 저장
	private JLabel jlbl;
	private JButton jbtn;
	
	public Ex01_Thursday(String title) { // 컨테이너 받아와서 컴포넌트 add
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼 클릭 시 종료
		// swing은 맨 처음에 컨테이너 얻어오기
		panel = (JPanel)getContentPane();
		panel.setLayout(new FlowLayout());
		jlbl = new JLabel("Happy ThursDay", (int)CENTER_ALIGNMENT);
		jbtn = new JButton("EXIT");
		
		panel.add(jlbl);
		jlbl.setPreferredSize(new Dimension(150,200));
		panel.add(jbtn);
		jbtn.setPreferredSize(new Dimension(200,200));
		setVisible(true);
		setSize(400, 250);
		setLocation(600, 400);
		
		//이벤트 리스너 추가
		jbtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직
		if(e.getSource()==jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}

	}
	public static void main(String[] args) {
		new Ex01_Thursday("title");
	}
}
