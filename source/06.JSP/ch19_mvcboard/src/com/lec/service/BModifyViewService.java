package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		int bid = Integer.parseInt(request.getParameter("bid"));
		request.setAttribute("modify_view", dao.modifyView_replyView(bid));
	}

}
