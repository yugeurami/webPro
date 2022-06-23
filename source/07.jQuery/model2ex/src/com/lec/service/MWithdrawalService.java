package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MWithdrawalService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("member");
		String mid = dto.getMid();
		MemberDao dao = MemberDao.getInstance();
		int result = dao.deleteMember(mid);
		if(result == MemberDao.SUCCESS) {
			session.invalidate();
			request.setAttribute("withdrawalResult", "회원 탈퇴 성공");
		}else {
			request.setAttribute("withdrawalResult", "회원 탈퇴 실패");
		}

	}

}
