package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;

public class BoardModifyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		int fid = Integer.parseInt(request.getParameter("fid"));
		dao.hitup(fid);
		request.setAttribute("content", dao.contentView(fid));
	}
}
