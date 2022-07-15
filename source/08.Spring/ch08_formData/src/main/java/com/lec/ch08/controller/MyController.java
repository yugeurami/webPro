package com.lec.ch08.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@ModelAttribute("cnt")
	public int cnt() {
		return 5;
	}
	
	@ModelAttribute("list")
	public ArrayList<String> list(){
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;
	}
	
	@RequestMapping("/")
	public String input() {
		return "member/input";
	}
	
	/*@RequestMapping("studentId/*")
	public String studentId(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		String uri = request.getRequestURI();
		String id = uri.substring(uri.lastIndexOf("/")+1);
		id = URLDecoder.decode(id, "utf-8");
		model.addAttribute("id", id);
		return "student/studentid";
	}*/
	
	@RequestMapping("studentId/{id}")
	public String studentId(@PathVariable("id") String id, Model model) {
		model.addAttribute("id", id);
		return "student/studentid";
	}
	
}