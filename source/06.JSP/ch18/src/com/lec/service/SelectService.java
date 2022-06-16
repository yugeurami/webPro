package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
//		int currentPage;
//		ArrayList<Dto> dto = dao.list(startRow, endRow);
//		request.setAttribute("Dto", dto);
		request.setAttribute("list", "list 결과");
	}

}
