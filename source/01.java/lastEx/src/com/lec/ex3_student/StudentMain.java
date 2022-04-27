package com.lec.ex3_student;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentMain extends JFrame implements ActionListener {
	private Container contenPane;
	private JPanel jpup,jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mnames;
	private JComboBox<String> comMname;
	private JButton btnSnoSearch, btnSnameSearch, btnMnameSearch, btnInput, btnUpdate, btnStudentOut, btnRegOut, btnReg, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private StudentDao dao = StudentDao.getInstance();
	private ArrayList<StudentDto> student;
	
	private void Setting(){
		txtSName.setText("");
		txtScore.setText("");
		txtSNo.setText("");
		comMname.setSelectedIndex(0);
	}

	public StudentMain(String title){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel();
		mnames = dao.mnameList();
		comMname = new JComboBox<String>(mnames);
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		txtScore = new JTextField(10);
		btnSnoSearch = new JButton("학번검색");
		btnSnameSearch = new JButton("이름검색");
		btnMnameSearch = new JButton("전공검색");
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnReg = new JButton("재적처리");
		btnRegOut = new JButton("재적자출력");
		btnExit = new JButton("종료");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("학번",(int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSnoSearch);
		jpup.add(new JLabel("이름",(int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSnameSearch);
		jpup.add(new JLabel("전공",(int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMnameSearch);
		jpup.add(new JLabel("점수",(int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnRegOut);
		jpbtn.add(btnReg);
		jpbtn.add(btnExit);
		
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(700,450));
		setLocation(200, 150);
		setVisible(true);
		
		btnSnoSearch.addActionListener(this);
		btnSnameSearch.addActionListener(this);
		btnMnameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnRegOut.addActionListener(this);
		btnReg.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSnoSearch) {
			String snoStr = txtSNo.getText().trim();
			if(snoStr.equals("")) {
				txtPool.setText("학번을 입력해주세요");
				return;
			}
			int sno = Integer.parseInt(snoStr);
			StudentDto dto = dao.selectSno(sno);
			if(dto!=null) {
				txtPool.setText(sno+" 검색 완료");
				System.out.println(dto);
				txtSName.setText(dto.getSname());
				comMname.setSelectedItem(dto.getMname());
				txtScore.setText(String.valueOf(dto.getScore()));
			} else {
				txtPool.setText(sno+" 은 유효하지 않은 학번입니다");
				Setting();
				return;
			}
		}else if(e.getSource() == btnSnameSearch){
			String sname = txtSName.getText().trim();
			if(sname.equals("")) {
				txtPool.setText("이름을 입력해주세요");
				return;
			}
			student = dao.selectSname(sname);
			if(student.size()==1) {
				txtPool.setText(sname+" 검색 완료");
				for(StudentDto d : student) {
					txtSNo.setText(String.valueOf(d.getSno()));
					comMname.setSelectedItem(d.getMname());
					txtScore.setText(String.valueOf(d.getScore()));
				}
			} else if(student.size()>1){
				txtPool.setText("등수\t이름(학번)\t\t학과명(학과번호)\t점수\n");
				txtPool.append("--------------------------------------------------------------------------------------------------------------------------\n");
				for(StudentDto d : student) {
					txtPool.append(d.toString());
				}
			}else {
				txtPool.setText("해당 이름의 학생이 없습니다");
				Setting();
				return;
			}
		}else if(e.getSource() == btnMnameSearch) {
			String mname = comMname.getSelectedItem().toString().trim();
			if(mname.equals("")) {
				txtPool.setText("전공을 선택 후 검색해주세요");
				Setting();
				return;
			}
			student = dao.selectMname(mname);
			if(student.size()>0) {
				txtPool.setText("등수\t이름(학번)\t\t학과명(학과번호)\t점수\n");
				txtPool.append("--------------------------------------------------------------------------------------------------------------------------\n");
				for(StudentDto d : student) {
					txtPool.append(d.toString());
				}
			} else {
				txtPool.setText("해당 학과의 학생이 없습니다");
				Setting();
				return;
			}
		}else if(e.getSource() == btnInput) {
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scoreStr = txtScore.getText().trim();
			txtPool.setText("");
			try {
				int score = 0;
				if(sname.equals("")||mname.equals("")) {
					txtPool.setText("이름, 학과를 전부 입력해주세요");
					return;
				}
				if(scoreStr.equals("")) {
					txtPool.setText("점수를 입력하지 않으면 0점으로 등록됩니다\n");
				} else {
					score = Integer.parseInt(scoreStr);
				}
				StudentDto newStudent = new StudentDto(sname, mname, score);
				int result = dao.insertStudent(newStudent);
				if(result == StudentDao.SUCCESS) {
					txtPool.append(sname+" 학생 입력 성공");
					Setting();
				}
			} catch (Exception e2) {
				txtPool.setText("점수는 0~100사이의 정수만 입력해주세요");
			}
		}else if(e.getSource() == btnUpdate) {
			String snoStr = txtSNo.getText().trim();
			String sname = txtSName.getText().trim();
			String mname = comMname.getSelectedItem().toString().trim();
			String scoreStr = txtScore.getText().trim();
			txtPool.setText("");
			try {
				int score = 0;
				int sno = 0;
				if(snoStr.equals("")) {
					txtPool.setText("학번을 입력해주세요");
					return;
				} else {
					sno = Integer.parseInt(snoStr);
				}
				if(sname.equals("")) {
					txtPool.setText("이름을 입력해주세요");
					return;
				}
				if(mname.equals("")) {
					txtPool.setText("학과를 입력해주세요");
					return;
				}
				if(scoreStr.equals("")) {
					txtPool.setText("점수를 입력하지 않으면 0점으로 등록됩니다\n");
				} else {
					score = Integer.parseInt(scoreStr);
				}
				StudentDto newStudent = new StudentDto(sno, sname, mname, score);
				int result = dao.updateStudent(newStudent);
				if(result == StudentDao.SUCCESS) {
					txtPool.append(sname+" 학생 입력 수정");
					Setting();
				}
			} catch (Exception e2) {
				txtPool.setText("점수는 0~100사이의 정수만 입력해주세요");
			}
		}else if(e.getSource() == btnStudentOut) {
			student = dao.selectAll();
			if(student.size()>0) {
				txtPool.setText("등수\t이름(학번)\t\t학과명(학과번호)\t점수\n");
				txtPool.append("--------------------------------------------------------------------------------------------------------------------------\n");
				for(StudentDto d : student) {
					txtPool.append(d.toString());
					Setting();
				}
			} else {
				txtPool.setText("데이터 베이스에 학생이 없습니다");
				Setting();
				return;
			}
		}else if(e.getSource() == btnRegOut) {
			student = dao.selectReg();
			if(student.size()>0) {
				txtPool.setText("등수\t이름(학번)\t\t학과명(학과번호)\t점수\n");
				txtPool.append("--------------------------------------------------------------------------------------------------------------------------\n");
				for(StudentDto d : student) {
					txtPool.append(d.toString());
				}
			} else {
				txtPool.setText("재적된 학생이 없습니다");
			}
		}else if(e.getSource() == btnReg) {
			String snoStr = txtSNo.getText().trim();
			try {
				int sno = 0;
				if(snoStr.equals("")) {
					txtPool.setText("학번을 입력해주세요");
					return;
				} else {
					sno = Integer.parseInt(snoStr);
				}
				StudentDto dto = dao.selectSno(sno);
				int result = dao.updateReg(dto);
				if(result == StudentDao.SUCCESS) {
					txtPool.setText(sno+" 학생 재적 처리");
					Setting();
				}
			} catch (Exception e2) {
				txtPool.setText(snoStr+" 은 유효하지 않은 학번입니다");
			}
		}else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new StudentMain("학사 관리 시스템");
		
	}
}
