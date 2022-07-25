package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping( value = "member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping( params = "method=joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}
	@RequestMapping( params = "method=join", method = RequestMethod.POST)
	public String join(Member member, Model model, HttpSession session) {
		memberService.joinMember(member, session);
		return "forward:main.do";
	}
}
