package com.lec.ch15.controller;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch15.model.Emp;
import com.lec.ch15.service.EmpService;
import com.lec.ch15.util.Paging;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value = "empList", method = RequestMethod.GET)
	public String empList(String pageNum, Model model) {
		model.addAttribute("empList", empService.empList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empList";
	}
	
	@RequestMapping(value = "dummyDataInsert", method = RequestMethod.GET)
	public String dummyDataInsert() {
		empService.dummyDataInsert50();
		return "redirect:empList.do";
	}
	
	@RequestMapping(value = "empDeptList", method = {RequestMethod.GET, RequestMethod.POST})
	public String empDeptList(String pageNum, Model model) {
		model.addAttribute("empDeptList", empService.empDeptList(pageNum));
		model.addAttribute("paging", new Paging(empService.totCnt(), pageNum, 10, 5));
		return "empDeptList";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String empDetail(int empno, Model model) {
		model.addAttribute("detail", empService.detail(empno));
		return "detail";
	}
	
	@RequestMapping(value = "updateView", method = {RequestMethod.GET, RequestMethod.POST})
	public String updateView(int empno, Model model) {
		model.addAttribute("empDto", empService.detail(empno));
		return "update";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(Emp emp, Date tempHiredate, Model model) {
		try {
			emp.setHiredate(Timestamp.valueOf(tempHiredate+ " 00:00:00"));
			model.addAttribute("updateResult", empService.update(emp));
		} catch (Exception e) {
			model.addAttribute("updateResult", "필드 값이 너무 깁니다. 수정 실패");
			return "forward:updateView.do";
		}
		return "forward:empDeptList.do";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int empno, Model model) {
		model.addAttribute("deleteResult", empService.delete(empno));
		return "forward:empDeptList.do";
	}
	
	@RequestMapping(value = "writeView", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeView(Model model) {
		model.addAttribute("deptList", empService.deptList());
		model.addAttribute("managerList", empService.managerList());
		return "write";
	}
	
	@RequestMapping(value = "confirmNo", method = RequestMethod.GET)
	public String confirmNo(int empno, Model model) {
		if(empService.detail(empno) == null) {
			model.addAttribute("msg", "사용가능한 사번입니다");
		}else {
			model.addAttribute("msg", "중복된 사번은 사용 불가합니다");
		}
		return "forward:writeView.do";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String write(Emp emp, Model model) {
		model.addAttribute("writeResult", empService.insert(emp));
		return "forward:empDeptList.do";
	}
}
