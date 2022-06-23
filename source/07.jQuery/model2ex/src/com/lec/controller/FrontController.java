package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.AdminLoginService;
import com.lec.service.BoardContentService;
import com.lec.service.BoardDeleteService;
import com.lec.service.BoardListService;
import com.lec.service.BoardModifyService;
import com.lec.service.BoardModifyViewService;
import com.lec.service.BoardWriteService;
import com.lec.service.EmailCheckService;
import com.lec.service.IdCheckService;
import com.lec.service.JoinService;
import com.lec.service.LoginService;
import com.lec.service.LogoutService;
import com.lec.service.MAllViewService;
import com.lec.service.MWithdrawalService;
import com.lec.service.MModifyService;
import com.lec.service.Service;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean join = false;
	private boolean login = false;
       
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
		if(command.equals("/main.do")) {
			viewPage = "main/main.jsp";
		}else if(command.equals("/joinView.do")){
			viewPage = "member/join.jsp";
			join = true;
		}else if(command.equals("/idCheck.do")) {
			service = new IdCheckService();
			service.execute(request, response);
			viewPage = "member/idCheck.jsp";
		}else if(command.equals("/loginView.do")){
			viewPage = "member/login.jsp";
			login = true;
		}else if(command.equals("/emailCheck.do")) {
			service = new EmailCheckService();
			service.execute(request, response);
			viewPage = "member/emailChk.jsp";
		}else if(command.equals("/join.do")) {
			if(join) {
				service = new JoinService();
				service.execute(request, response);
				join = false;
			}
			viewPage = "loginView.do";
		}else if(command.equals("/login.do")) {
			if(login) {
				service = new LoginService();
				service.execute(request, response);
				login = false;
			}
			viewPage = "main.do";
		}else if(command.equals("/adminLoginView.do")){
			login = true;
			viewPage = "admin/adminLogin.jsp";		
		}else if(command.equals("/adminLogin.do")) {
			if(login) {
				service = new AdminLoginService();
				service.execute(request, response);
				login = false;
			}
			viewPage = "allView.do";
		}else if(command.equals("/allView.do")) {
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "admin/mAllView.jsp";
		}else if(command.equals("/logout.do")) {
			service = new LogoutService();
			service.execute(request, response);
			viewPage = "main.do";
		}else if(command.equals("/modifyView.do")) {
			join = true;
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) {
			if(join) {
				service = new MModifyService();
				service.execute(request, response);
			}
			viewPage = "main.do";
		}else if(command.equals("/withdrawal.do")) {
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/boardList.do")) {
			service = new BoardListService();
			service.execute(request, response);
			viewPage = "freeBoard/boardList.jsp";
		}else if(command.equals("/boardContent.do")) {
			service = new BoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/boardContent.jsp";			
		}else if(command.equals("/boardWriteView.do")) {
			viewPage = "freeBoard/boardWrite.jsp";
		}else if(command.equals("/boardWrite.do")) {
			service = new BoardWriteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(command.equals("/boardDelete.do")) {
			service = new BoardDeleteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(command.equals("/boardModifyView.do")) {
			service = new BoardModifyViewService();
			service.execute(request, response);
			viewPage = "freeBoard/boardModify.jsp";
		}else if(command.equals("/boardModify.do")) {
			service = new BoardModifyService();
			service.execute(request, response);
			viewPage = "boardList.do";			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
