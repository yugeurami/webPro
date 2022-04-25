package com.lec.ex2_person_dtoDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class PersonMngGUI extends JFrame implements ActionListener {
	//화면에 들어간 컴포넌트
	private Container contPane;
	private JPanel jpup,jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	//db
	private PersonDao dao = PersonDao.getInstance();
	private ArrayList<PersonDto> person;

	public PersonMngGUI(String title){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contPane = getContentPane();
		contPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(5,2));
		jpbtn = new JPanel();
		txtName = new JTextField(20);
		jnames = dao.jnameList();
		comJob = new JComboBox<String>(jnames); // 직업명 목록이 콤보박스에
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("icon/join.png");
		btnInput = new JButton("입력",icon1);
		ImageIcon icon2 = new ImageIcon("icon/search.png");
		btnSearch = new JButton("직업조회", icon2);
		ImageIcon icon3 = new ImageIcon("icon/output.png");
		btnOutput = new JButton("전체출력", icon3);
		ImageIcon icon4 = new ImageIcon("icon/exit.png");
		btnExit = new JButton("종료", icon4);
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));
		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool);
		// 생성된 컴포넌트 추가
		jpup.add(new JLabel("이름",(int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("직업",(int) CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("국어",(int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("영어",(int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("수학",(int) CENTER_ALIGNMENT));
		jpup.add(txtMat);
		
		jpbtn.add(btnInput);
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		
		contPane.add(jpup);
		contPane.add(jpbtn);
		contPane.add(scrollPane);
		setSize(new Dimension(700,450));
		setLocation(200, 150);
		setVisible(true);
		
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) { // 이벤트 로직 추가
		if(e.getSource() == btnInput) {// 인서트
			String pname = txtName.getText().trim();
			String jname = comJob.getSelectedItem().toString().trim();
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			if(pname.equals("")||jname.equals("")||korStr.equals("")||matStr.equals("")||engStr.equals("")) {
				System.out.println("이름, 직업, 국어, 영어, 수학 모두 입력하셔야 합니다");
				return;
			}
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			PersonDto newPerson = new PersonDto(pname, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
			if(result == PersonDao.SUCCESS) {
				txtPool.setText(pname+"님 입력 성공");
				txtName.setText("");
				comJob.setSelectedIndex(0);//콤보박스를 0번째 선택
				comJob.setSelectedItem(""); // 콤보 박스를 ""이 있는 것으로 선택
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			}
		}else if(e.getSource() == btnSearch) { 
			if(comJob!=null) { // 직업별 조회
				String jname = comJob.getSelectedItem().toString().trim();
				if(jname.equals("")) {
					txtPool.setText("직업 선택 후 조회하세요");
					return;
				}
				person = dao.selectJname(jname);
				if(person.isEmpty()) {
					txtPool.setText("해당 직업에는 등록된 사람이 없습니다");
					return;
				}
				txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
				for(PersonDto dto : person) {
					txtPool.append(dto.toString()+"\n");
				}
			} else {
				System.out.println("직업이 선택되지 않았습니다");
			}
		}else if(e.getSource() == btnOutput) { // 전체 조회 결과
			person = dao.selectAll();
			if(person.isEmpty()) {
				txtPool.setText("등록된 사람이 없습니다");
				return;
			}
			txtPool.setText("등수\t이름\t직업\t국어\t영어\t수학\t총점\n");
			for(PersonDto dto : person) {
				txtPool.append(dto.toString()+"\n");
			}
		}else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new PersonMngGUI("연예인 성적관리");
	}
} // class
