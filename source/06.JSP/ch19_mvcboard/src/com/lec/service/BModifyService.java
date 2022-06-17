package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;
import com.lec.dto.BoardDto;

public class BModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();
		request.setAttribute("modifyResult", dao.modify(new BoardDto(bid, bname, btitle, bcontent, null, 0, 0, 0, 0, bip)));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
	}

}
