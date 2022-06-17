package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		int bid = Integer.parseInt(request.getParameter("bid"));
		request.setAttribute("reply_view", dao.modifyView_replyView(bid));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
	}

}
