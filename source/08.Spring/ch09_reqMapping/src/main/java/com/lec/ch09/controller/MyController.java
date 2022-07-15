package com.lec.ch09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping(value =  "main.do", method = RequestMethod.GET )
	public String main() {
		return "main";
	}
	
	@RequestMapping(value = "student" , method = RequestMethod.GET )
	public String student(String id, Model model) {
		model.addAttribute("method", "GET");
		model.addAttribute("id", id);
		return "studentId";
	}
	@RequestMapping(value = "student" , method = RequestMethod.POST )
	public ModelAndView student(String id, ModelAndView mav) {
		mav.addObject("method", "POST");
		mav.addObject("id", id);
		mav.setViewName("studentId");
		return mav;
	}
	
	@RequestMapping(value = "idConfirm", method = RequestMethod.GET)
	public String idConfirm(String id, Model model) {
		model.addAttribute("id", id);
		if(id.equals("aaa")) {
			//return "redirect:studentOK.do"; redirect나 forward를 적어줘야 요청 경로라고 인식한다 
			// redirect로 요청하면 가지고 있는 값들이 전부 사라진다! 주의!
			return "forward:studentOk.do"; 
		}
		return "redirect:studentNg.do?id="+id;
	}
	@RequestMapping(value = "studentOk.do", method = RequestMethod.GET) // 이전의 방식과 같은 방식으로 적어줄 것
	public String studentOk() {
		return "studentOk";
	}
	@RequestMapping(value = "studentNg.do", method = RequestMethod.GET)
	public String studentNg(String id) {
		return "studentNg";
	}
	@RequestMapping(value = "fullpath", method = RequestMethod.GET)
	public String fullpath() {
		return "redirect:http://www.naver.com";
	}
}
