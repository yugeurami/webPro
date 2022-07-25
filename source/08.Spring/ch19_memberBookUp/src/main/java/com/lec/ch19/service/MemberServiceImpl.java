package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public Member idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession session) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String name = member.getMname();
			String mail = member.getMmail();
			
			String content = "<div style=\"width:500px; margin:0 auto; text-align:center\">\n" + 
					"	<h1 style=\"color:blue;\">"+name+"님 회원가입 감사합니다</h1>\n" + 
					"	<div>\n" + 
					"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\n" + 
					"		<p><img src=\"http://localhost:8090/ch19/img/coupon.jpg\"></p>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"		<p style=\"color:blue;\">파란 글씨 부분</p>\n" + 
					"		<img src=\"https://clova-phinf.pstatic.net/MjAxODAzMjlfOTIg/MDAxNTIyMjg3MzM3OTAy.WkiZikYhauL1hnpLWmCUBJvKjr6xnkmzP99rZPFXVwgg.mNH66A47eL0Mf8G34mPlwBFKP0nZBf2ZJn5D4Rvs8Vwg.PNG/image.png\">\n" + 
					"	</div>\n" + 
					"</div>"; 
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
				mimeMessage.setFrom(new InternetAddress("kimyujin4696@gmail.com"));
				mimeMessage.setSubject( name + "님 회원가입 감사합니다(쿠폰 동봉)");
				mimeMessage.setText(content, "utf-8", "html");
			}
		};
		mailSender.send(message);
		session.setAttribute("mid", member.getMid());
		return memberDao.joinMember(member); // member insert
	}


	@Override
	public String loginCheck(String mid, String mpw, HttpSession session) {
		String result = "로그인 성공";
		Member member = memberDao.getMemberDto(mid);
		if(member == null) {
			result = "유효하지 않은 ID입니다";
		}else if(!mpw.equals(member.getMpw())){
			result = "비밀번호가 맞지 않습니다";
		}else {
			session.setAttribute("member", member);
			session.setAttribute("mid", mid);
		}
		return result;
	}
	
	@Override
	public Member getMemberDto(String mid) {
		return memberDao.getMemberDto(mid);
	}
	
	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}

}
