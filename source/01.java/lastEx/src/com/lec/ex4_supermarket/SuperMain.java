package com.lec.ex4_supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SuperMain extends JFrame implements ActionListener{
	private Container contPane;
	private JPanel jpup, jpbtn;
	private JTextField txtCid, txtCname, txtCtel, txtCpoint, txtPay;
	private Vector<String> lnames;
	private JComboBox<String> comLname;
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch, btnPointBuy, 
					btnBuy, btnLevelOutput, btnOutputAll, btnJoin, btnUpdateTel, btnDelete, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	private SuperDao dao = SuperDao.getInstance();
	private ArrayList<SuperDto> customer;
	
	private void Setting() {
		txtCid.setText("");
		txtCname.setText("");
		txtCtel.setText("");
		txtCpoint.setText("");
		txtPay.setText("");
	}
	
	private void print() {
		txtPool.setText("ID\t전화\t이름\t포인트\t구매누적액\t고객레벨\t레벨업을 위해 필요한 구매금액\n");
		for(int i = 0 ; i<180 ; i++) {
			txtPool.append("-");
		}
		txtPool.append("\n");
	}
	
	public SuperMain(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contPane = getContentPane();
		contPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6,3));
		jpbtn = new JPanel();
		lnames = dao.levelList();
		comLname = new JComboBox<String>(lnames);
		txtCid = new JTextField(20);
		txtCname = new JTextField(20);
		txtCtel = new JTextField(20);
		txtCpoint = new JTextField(20);
		txtPay = new JTextField(20);
		btnCidSearch = new JButton("아이디 검색");
		btnCnameSearch = new JButton("고객 이름 검색");
		btnCtelSearch = new JButton("폰 4자리(FULL) 검색");
		btnPointBuy = new JButton("포인트로만 구매");
		btnBuy = new JButton("물품 구매");
		btnLevelOutput = new JButton("등급별출력");
		btnOutputAll = new JButton("전체출력");
		btnJoin = new JButton("회원가입");
		btnUpdateTel = new JButton("번호수정");
		btnDelete = new JButton("회원탈퇴");
		btnExit = new JButton("나가기");
		txtPool = new JTextArea(8, 70);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("아  이  디", (int) CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("고 객 전 화", (int) CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("고 객 이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("포 인 트", (int) CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnPointBuy);
		jpup.add(new JLabel("구 매 금 액", (int) CENTER_ALIGNMENT));
		jpup.add(txtPay);
		jpup.add(new JLabel());
		jpup.add(new JLabel("고 객 등 급", (int) CENTER_ALIGNMENT));
		jpup.add(comLname);
		
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelOutput);
		jpbtn.add(btnOutputAll);
		jpbtn.add(btnJoin);
		jpbtn.add(btnUpdateTel);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		
		contPane.add(jpup);
		contPane.add(jpbtn);
		contPane.add(scrollPane);
		setSize(new Dimension(800,400));
		setLocation(200, 150);
		setVisible(true);
		
		btnCidSearch.addActionListener(this); 
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this); 
		btnPointBuy.addActionListener(this); 
		btnBuy.addActionListener(this);
		btnLevelOutput.addActionListener(this); 
		btnOutputAll.addActionListener(this); 
		btnJoin.addActionListener(this);
		btnUpdateTel.addActionListener(this); 
		btnDelete.addActionListener(this); 
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCidSearch) {
			try {
				int cid = Integer.parseInt(txtCid.getText().trim());
				SuperDto dto = dao.searchId(cid);
				if(dto!=null) {
					txtCtel.setText(dto.getCtel());
					txtCname.setText(dto.getCname());
					txtCpoint.setText(String.valueOf(dto.getCpoint()));
					comLname.setSelectedItem(dto.getLname());
					print();
					txtPool.append(dto.toString());
				} else {
					txtPool.setText("검색되지 않는 ID입니다");
					Setting();
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 고객ID를 입력하시고 아이디 검색하세요");
				Setting();
			}
		}else if(e.getSource() == btnCtelSearch) {
			String ctel = txtCtel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("번호 입력 후 검색하세요");
				return;
			} else if(ctel.length()<4) {
				txtPool.setText("적어도 전화번호 4자리 이상은 입력하셔야 합니다");
				Setting();
				return;
			}
			customer = dao.telSearch(ctel);
			if(customer.size()>0) {
				Setting();
				print();
				for(SuperDto d :customer) {
					txtPool.append(d.toString());
					txtCid.setText(String.valueOf(d.getCid()));
					txtCtel.setText(d.getCtel());
					txtCname.setText(d.getCname());
					txtCpoint.setText(String.valueOf(d.getCpoint()));
					comLname.setSelectedItem(d.getLname());
				}
			} else {
				txtPool.setText("해당 전화번호의 고객이 검색되지 않습니다. 회원가입 해 주세요");
			}
		}else if(e.getSource() == btnCnameSearch) {
			String cname = txtCname.getText().trim();
			if(cname.equals("")) {
				txtPool.setText("이름 입력 후 검색하세요");
				return;
			}
			customer = dao.nameSearch(cname);
			if(customer.size()>0) {
				print();
				for(SuperDto d :customer) {
					txtPool.append(d.toString());
					txtCid.setText(String.valueOf(d.getCid()));
					txtCtel.setText(d.getCtel());
					txtCpoint.setText(String.valueOf(d.getCpoint()));
					comLname.setSelectedItem(d.getLname());
				}
			} else {
				txtPool.setText("해당 이름의 고객이 검색되지 않습니다. 회원가입 해 주세요");
				Setting();
			}
		}else if(e.getSource() == btnPointBuy) {
			try {
				String cidStr = txtCid.getText().trim();
				String payStr = txtPay.getText().trim();
				int cid = Integer.parseInt(cidStr);
				int pay = Integer.parseInt(payStr);
				if(cidStr.equals("")) {
					txtPool.setText("★ ★ ★ 고객 검색 후에 구매해주세요 ★ ★ ★");
					return;
				}
				if(payStr.equals("")) {
					txtPool.setText("구매 금액을 입력해주세요");
					return;
				}
				
				int result = dao.pointBuy(cid, pay);
				if(result == SuperDao.SUCCESS) {
					txtPool.setText("포인트 구매 성공");
					SuperDto dto = dao.searchId(cid);
					txtCpoint.setText(String.valueOf(dto.getCpoint()));
					txtPay.setText("");
				} else {
					txtPool.setText("포인트가 부족하여 포인트로 구매 불가합니다");
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 값을 입력해주세요");
			}
		}else if(e.getSource() == btnBuy) {
			try {
				String cidStr = txtCid.getText().trim();
				if(cidStr.equals("")) {
					txtPool.setText("고객 검색 후 구매를 진행해주세요");
					return;
				}
				String payStr = txtPay.getText().trim();
				if(payStr.equals("")) {
					txtPool.setText("구매 금액을 입력해주세요");
					return;
				}
				int cid = Integer.parseInt(cidStr);
				int pay = Integer.parseInt(payStr);
				int result = dao.buy(cid, pay);
				if(result == SuperDao.SUCCESS) {
					txtPool.setText("물품 구매 및 레벨 조정 성공");
					SuperDto dto = dao.searchId(cid);
					txtCpoint.setText(String.valueOf(dto.getCpoint()));
					comLname.setSelectedItem(dto.getLname());
					txtPay.setText("");
				}
			} catch (Exception e2) {
				txtPool.setText("유효한 값을 입력해주세요");
			}
		}else if(e.getSource() == btnLevelOutput) {
			String lname = comLname.getSelectedItem().toString().trim();
			if(lname.equals("")) {
				txtPool.setText("원하시는 등급을 선택하시고 검색하세요");
				return;
			}
			customer = dao.levelOutput(lname);
			if(customer.size()>0) {
				print();
				for(SuperDto d :customer) {
					txtPool.append(d.toString());
				}
				Setting();
				txtPool.append("총 "+customer.size()+"명");
			} else {
				txtPool.setText("해당 등급에 등록된 고객이 없습니다");
				Setting();
			}
		}else if(e.getSource() == btnOutputAll) {
			customer = dao.customerOutput();
			if(customer.size()>0) {
				print();
				for(SuperDto d :customer) {
					txtPool.append(d.toString());
				}
				Setting();
				txtPool.append("총 "+customer.size()+"명");
			} else {
				Setting();
				txtPool.setText("등록된 고객이 없습니다");
			}
		}else if(e.getSource() == btnJoin) {
			String ctel = txtCtel.getText().toString().trim();
			String cname = txtCname.getText().toString().trim();
			if(ctel.equals("")||cname.equals("")) {
				txtPool.setText("전화번호와 이름을 입력 후 회원가입이 가능해요");
				return;
			}
			StringTokenizer token = new StringTokenizer(ctel, "-");
			if(token.countTokens()!=3) {
				txtPool.setText("유효한 전화번호 형식이 아닙니다");
				return;
			}
			int result = dao.joinCustomer(cname, ctel);
			if(result == dao.SUCCESS) {
				txtPool.setText("회원가입 감사합니다. 포인트 1000점을 회원가입선물로 드립니다");
				txtCpoint.setText("1000");
				comLname.setSelectedItem("일반");
			}
		}else if(e.getSource() == btnUpdateTel) {
			String cidStr = txtCid.getText().toString().trim();
			if(cidStr.equals("")) {
				txtPool.setText("ID를 입력해주세요");
				return;
			}
			String ctel = txtCtel.getText().toString().trim();
			StringTokenizer token = new StringTokenizer(ctel, "-");
			int cid = Integer.parseInt(cidStr);
			SuperDto dto = dao.searchId(cid);
			if(dto!=null) {
				txtCname.setText(dto.getCname());
				txtCpoint.setText(String.valueOf(dto.getCpoint()));
				comLname.setSelectedItem(dto.getLname());
			}
			if(ctel.equals("")) {
				txtPool.setText("바꾸실 전화번호를 입력해주세요");
				return;
			} else if(token.countTokens()!=3) {
				txtPool.setText("유효한 전화번호 형식이 아닙니다");
				return;
			}
			int result = dao.updateTel(ctel, cid);
			if(result == dao.SUCCESS) {
				txtPool.setText("전화번호가 수정되었습니다");
			}
		}else if(e.getSource() == btnDelete) {
			txtCid.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtPay.setText("");
			String ctel = txtCtel.getText().toString().trim();
			if(ctel.equals("")) {
				txtPool.setText("전화번호를 입력 후 회원 탈퇴가 가능합니다");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result == dao.SUCCESS) {
				txtPool.setText(ctel+" 님의 회원 탈퇴가 완료되었습니다");
			}else {
				txtPool.setText("등록된 전화번호가 아니라 탈퇴가 불가능합니다");
			}
		}else if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		new SuperMain("슈퍼마켓 프로그램");
	}
}
