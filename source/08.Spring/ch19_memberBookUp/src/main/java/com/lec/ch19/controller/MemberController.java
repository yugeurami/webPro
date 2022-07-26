package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping( params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("result", memberService.idConfirm(mid));
		return "member/idConfirm";
	}
	
	@RequestMapping( params = "method=join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mDto") Member member, Model model, HttpSession session) {
		model.addAttribute("joinResult", memberService.joinMember(member, session));
		return "forward:member.do?method=loginForm";
	}
	
	@RequestMapping( params = "method=loginForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginForm() {
		return "member/loginForm";
	}
	
	@RequestMapping( params = "method=login", method = RequestMethod.POST)
	public String login(String mid, String mpw, HttpSession session, Model model) {
		String result = memberService.loginCheck(mid, mpw, session);
		if(result.equals("로그인 성공")) {
			return "redirect:main.do";
		}else {
			model.addAttribute("mid", mid);
			model.addAttribute("mpw", mpw);
			model.addAttribute("result", result);
			return "forward:member.do?method=loginForm";
		}
	}
	
	@RequestMapping( params = "method=modifyForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm() {
		return "member/modifyForm";
	}
	
	@RequestMapping( params = "method=modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute("mDto") Member member, Model model, HttpSession session) {
		int result = memberService.modifyMember(member);
		if(result == 0) {
			return "forward:member.do?method=modifyForm";
		}else{
			session.setAttribute("member", member);
			model.addAttribute("modifyResult", result);
			return "forward:main.do";
		}
	}
	
	@RequestMapping(params = "method=logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main.do";
	}
}
