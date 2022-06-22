package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class IdCheckService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse responce) {
		String mid = request.getParameter("mid");
		MemberDao dao = MemberDao.getInstance();
		int result = dao.idCheck(mid);
		if(result == MemberDao.MEMBER_EXISTENT) {
			request.setAttribute("idCheckResult", "중복된 ID입니다");
		}else {
			request.setAttribute("idCheckResult", "사용 가능한 ID입니다");
		}
		
	}

}
