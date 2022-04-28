package quiz1;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {
	private Container contPane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone, txtName, txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scrollPane;
	private CustomerDao dao = CustomerDao.getInstance();
	private ArrayList<CustomerDto> customer;
	
	private void reset() {
		txtPhone.setText("");
		txtName.setText("");
		txtPoint.setText("");
	}
	
	private void print() {
		jta.setText("이름\t전화번호\t\t포인트\n");
		for(int i = 0 ; i<80 ; i++) {
			jta.append("-");
		}
		jta.append("\n");
	}

	public CustomerMng(String title) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contPane = getContentPane();
		contPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3,2));
		jpdown = new JPanel();
		txtPhone = new JTextField(15);
		txtName = new JTextField(15);
		txtPoint = new JTextField(15);
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		jta = new JTextArea(15, 30);
		scrollPane = new JScrollPane(jta);
		
		jpup.add(new JLabel("폰번호", (int) CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이 름", (int) CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트", (int) CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		
		contPane.add(jpup);
		contPane.add(jpdown);
		contPane.add(scrollPane);
		setSize(new Dimension(450,450));
		setLocation(200, 150);
		setVisible(true);
		
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == btnJoin) {
			jta.setText("");
			String ctel = txtPhone.getText().trim();
			String cname = txtName.getText().trim();
			StringTokenizer pToken = new StringTokenizer(ctel, "-");
			if(ctel.equals("")) {
				jta.setText("전화번호를 입력해주세요");
				return;
			} else if(pToken.countTokens()!=3){
				jta.setText("유효한 전화번호 형식이 아닙니다");
				return;
			}
			if(cname.equals("")) {
				jta.setText("이름을 입력해주세요");
				return;
			}
			int result = dao.Join(ctel, cname);
			if(result == dao.SUCCESS) {
				jta.setText(cname+"님 가입되셨습니다. \n포인트 1000점을 회원가입 선물로 드립니다");
				reset();
			}
		}else if (a.getSource() == btnSearch) {
			jta.setText("");
			String ctel = txtPhone.getText().trim();
			if(ctel.equals("")) {
				jta.setText("전화번호를 입력해주세요");
				return;
			} else if(ctel.length()<4) {
				jta.setText("전화번호는 최소 4글자는 입력하셔야합니다");
				return;
			}
			customer = dao.Search(ctel);
			if(customer.size()>1) {
				print();
				for(CustomerDto d :customer) {
					jta.append(d.toString());
				}
				reset();
			} else if(customer.size()==1) {
				for(CustomerDto d :customer) {
					txtName.setText(d.getCname());
					txtPhone.setText(d.getCtel());
					txtPoint.setText(String.valueOf(d.getCpoint()));
				}
			} else {
				jta.setText("해당 번호로 등록된 고객이 없습니다");
				reset();
			}
		}else if (a.getSource() == btnOutput) {
			jta.setText("");
			customer = dao.Output();
			if(customer.size()>0) {
				print();
				for(CustomerDto d :customer) {
					jta.append(d.toString());
				}
				reset();
			} else {
				jta.setText("데이터 베이스에 등록된 고객이 없습니다");
			}
		}else if (a.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}

}
