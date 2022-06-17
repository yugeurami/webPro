package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;
import com.lec.dto.BoardDto;

public class BWriteService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bip = request.getRemoteAddr();
		int result = dao.writeBoard(new BoardDto(0, bname, btitle, bcontent, null, 0, 0, 0, 0, bip));
		request.setAttribute("writeResult", result);
	}

}
