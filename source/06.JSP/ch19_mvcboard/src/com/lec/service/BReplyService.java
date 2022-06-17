package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;
import com.lec.dto.BoardDto;

public class BReplyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = BoardDao.getInstance();
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		int bgroup = Integer.parseInt(request.getParameter("bgroup"));
		int bstep = Integer.parseInt(request.getParameter("bstep"));
		int bindent = Integer.parseInt(request.getParameter("bindent"));
		String bip = request.getRemoteAddr();
		request.setAttribute("replyResult", dao.reply(new BoardDto(0, bname, btitle, bcontent, null, 0, bgroup, bstep, bindent, bip)));
		request.setAttribute("pageNum", request.getParameter("pageNum"));
	}

}
