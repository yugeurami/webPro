package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class QuizValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Quiz.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Quiz quiz = (Quiz)target;
		String name = quiz.getName();
		int kor = quiz.getKor();
		int eng = quiz.getEng();
		int mat = quiz.getMat();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no");
		
		if(kor<=0 || kor>100 || eng<=0 || eng>100 || mat<=0 || mat>100) {
			errors.rejectValue("kor", "no");
		}
	}
	
}
