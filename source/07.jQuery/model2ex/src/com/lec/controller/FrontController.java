package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.EmailCheckService;
import com.lec.service.IdCheckService;
import com.lec.service.JoinService;
import com.lec.service.Service;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean join = false;
       
    public FrontController() {
        super();
    }

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
		String viewPage	= null;
		Service	service = null; 
		if(command.equals("/joinView.do")){
			viewPage = "/member/join.jsp";
			join = true;
		}else if(command.equals("/idCheck.do")) {
			service = new IdCheckService();
			service.execute(request, response);
			viewPage = "member/idCheck.jsp";
		}else if(command.equals("/loginView.do")){
			viewPage = "/member/login.jsp";
		}else if(command.equals("/emailChk.do")) {
			service = new EmailCheckService();
			service.execute(request, response);
			viewPage = "member/emailChk.jsp";
		}else if(command.equals("/join.do")) {
			if(join) {
				service = new JoinService();
				service.execute(request, response);
				join = false;
			}
			viewPage = "member/login.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
