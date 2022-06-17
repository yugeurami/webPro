package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		int bid = Integer.parseInt(request.getParameter("bid"));
		request.setAttribute("deleteResult", dao.delete(bid));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
	}

}
