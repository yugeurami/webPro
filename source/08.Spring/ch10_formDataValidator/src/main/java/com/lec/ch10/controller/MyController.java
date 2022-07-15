package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Student;
import com.lec.ch10.vo.StudentValidator;

@Controller
public class MyController {
	@RequestMapping(value = "inputForm", method = RequestMethod.GET)
	public String inputForm() {
		return "ex/inputForm";
	}
	
	@RequestMapping(value = "input", method = RequestMethod.GET)
	public String input(Student student, Errors errors, Model model) {
		String viewPage = "ex/inputResult";
		//검증 객체를 이용해서 검증 method를 호출
		/*if(에러를 잡았다){
			viewPage = "inputForm.do";
			에러 메세지 model에 add
		*/
		StudentValidator validator = new StudentValidator();
		validator.validate(student, errors);
		if(errors.hasErrors()) {
			if(errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수 입력 사항");
			}
			if(errors.getFieldError("id") != null) {
				model.addAttribute("idError", "id는 자연수만 입력 가능합니다");
			}
			return "ex/inputForm";
		}
		return viewPage;
	}
}
