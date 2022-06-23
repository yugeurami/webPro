package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BoardDeleteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fid = Integer.parseInt(request.getParameter("fid"));
		BoardDao dao = BoardDao.getInstance();
		request.setAttribute("deleteResult", dao.delete(fid));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
	}

}
