package com.lec.ex3_homework;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener {
	private Container 	contenPane;
	private JPanel 		jp1;
	private JPanel 		jp2;
	private JTextField 	txtName;
	private JTextField 	txtTel;
	private JTextField 	txtAge;
	private ImageIcon 	icon1;
	private ImageIcon 	icon2;
	private JButton 	btnInput;
	private JButton		btnOutput;
	private ArrayList<Person> person = new ArrayList<Person>(); 
	private OutputStream os = null;
	
	public MyFrame(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jp1 		= new JPanel(new GridLayout(3,2));
		jp2 		= new JPanel();
		txtName 	= new JTextField();
		txtTel		= new JTextField();
		txtAge		= new JTextField();
		icon1 		= new ImageIcon("icon/join.png");
		icon2		= new ImageIcon("icon/output.png");
		btnInput	= new JButton("INPUT", icon1);
		btnOutput	= new JButton("OUTPUT", icon2);
		
		jp1.add(new JLabel("NAME", (int)CENTER_ALIGNMENT));
		jp1.add(txtName);
		jp1.add(new JLabel("TEL", (int)CENTER_ALIGNMENT));
		jp1.add(txtTel);
		jp1.add(new JLabel("AGE", (int)CENTER_ALIGNMENT));
		jp1.add(txtAge);
		contenPane.add(jp1, BorderLayout.NORTH);
		
		jp2.add(btnInput);
		btnInput.setPreferredSize(new Dimension(150, 50));
		jp2.add(btnOutput);
		btnOutput.setPreferredSize(new Dimension(150, 50));
		contenPane.add(jp2);
		
		setVisible(true);
		setBounds(500, 400, 350, 160);
		
		btnInput.addActionListener(this);
		btnOutput.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnInput)) {
			boolean chk = true;
			String name = txtName.getText().trim();
			if (name.equals("")) {
				System.out.println("이름을 입력해주세요");
				chk = false;
				return;
			}
			String tel = txtTel.getText().trim();
			if (tel.equals("")) {
				System.out.println("전화번호를 입력해주세요");
				chk = false;
				return;
			} else if(	tel.indexOf("-") == tel.lastIndexOf("-") || 
						tel.indexOf("-")<2 ||
						tel.lastIndexOf("-")>10) {
					System.out.println("전화번호 형식을 확인해주세요");
					chk = false;
					return;
			}
			for(Person p : person) {
				if(p.getTel().equals(tel)) {
					System.out.println("같은 번호가 있어서 회원가입이 불가능합니다.");
					chk = false;
					return;
				}
			}
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText());
			} catch (Exception e2) {
				System.out.println("나이를 입력해주세요");
				chk = false;
				return;
			}			
			if(age==0) {
				System.out.println("나이를 입력해주세요");
				chk = false;
				return;
			} else if(age<0 || age>150) {
				System.out.println("나이를 입력해주세요");
				chk = false;
				return;
			}
		
			if(chk=true) {
				person.add(new Person(name, tel, age));
			}
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
			} else if(e.getSource().equals(btnOutput)) {
				if(person.size()==0) {
					System.out.println("추가된 사람이 없습니다");
					return;
				}
				try {
					os = new FileOutputStream("src/com/lec/ex3_homework/person.txt");
					for(int i = 0 ; i<person.size() ; i++){
						String msg = person.get(i).toString();
						byte[] bs = msg.getBytes();
						os.write(bs);
					}
				} catch (FileNotFoundException e1) {
					System.out.println("폴더를 찾을 수 없습니다");
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
				for(Person p : person) {
					System.out.print(p);
				}
			}
	}
	public static void main(String[] args) {
		new MyFrame("Person");
	}
}
