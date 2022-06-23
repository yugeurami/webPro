package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.AdminDao;

public class AdminLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		AdminDao dao = AdminDao.getInstance();
		int result = dao.login(aid, apw);
		if(result == AdminDao.SUCCESS) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", dao.getAdmin(aid));
			request.setAttribute("loginResult", "로그인성공");
		}else {
			request.setAttribute("loginError", "로그인 실패");
		}
	}

}
