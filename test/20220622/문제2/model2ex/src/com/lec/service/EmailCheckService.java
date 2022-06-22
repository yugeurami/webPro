package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class EmailCheckService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String memail = request.getParameter("memail");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.emailCheck(memail);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("emailCheckResult", "중복된 이메일입니다");
		}else {
			request.setAttribute("emailCheckResult", "사용가능한 이메일입니다");			
		}
	}

}
