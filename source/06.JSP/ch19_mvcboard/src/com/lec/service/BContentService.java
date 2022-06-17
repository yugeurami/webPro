package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		int bid = Integer.parseInt(request.getParameter("bid"));
		request.setAttribute("content", dao.contentView(bid));
	}

}
