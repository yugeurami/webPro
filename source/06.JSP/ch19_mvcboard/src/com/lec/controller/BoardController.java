package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BContentService;
import com.lec.service.BDeleteService;
import com.lec.service.BListService;
import com.lec.service.BModifyService;
import com.lec.service.BModifyViewService;
import com.lec.service.BReplyService;
import com.lec.service.BReplyViewService;
import com.lec.service.BWriteService;
import com.lec.service.Service;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean write_view = false; // 새로고침하면 계속 같은 글이 작성되는 것을 막기 위해
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/list.do")) {
			service = new BListService();
			service.execute(request, response);
			viewPage = "board/list.jsp";
		}else if(command.equals("/write_view.do")) {
			viewPage = "board/write_view.jsp";
			write_view = true;
		}else if(command.equals("/write.do")) {
			if(write_view) {
				service = new BWriteService();
				service.execute(request, response);
				write_view = false;
			}
			viewPage = "list.do";
		}else if(command.equals("/content_view.do")) {
			service = new BContentService();
			service.execute(request, response);
			viewPage = "board/content_view.jsp";
			write_view = true;
		}else if(command.equals("/modify_view.do")) {
			service = new BModifyViewService();
			service.execute(request, response);
			viewPage = "board/modify_view.jsp";	
			write_view = true;
		}else if(command.equals("/modify.do")) {
			if(write_view) {
				service = new BModifyService();
				service.execute(request, response);
				write_view = false;
			}
			viewPage = "list.do";
		}else if(command.equals("/delete.do")) {
			if(write_view) {
				service = new BDeleteService();
				service.execute(request, response);
				write_view = false;
			}
			viewPage = "list.do";									
		}else if(command.equals("/reply_view.do")) {
			service = new BReplyViewService();
			service.execute(request, response);
			viewPage = "board/reply_view.jsp";	
			write_view = true;
		}else if(command.equals("/reply.do")) {
			if(write_view) {
				service = new BReplyService();
				service.execute(request, response);
				write_view = false;
			}
			viewPage = "list.do";												
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
