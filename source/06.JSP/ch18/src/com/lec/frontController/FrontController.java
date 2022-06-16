package com.lec.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.DeleteService;
import com.lec.service.InsertService;
import com.lec.service.SelectService;
import com.lec.service.Service;
import com.lec.service.UpdateService;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();// /ch18/*.do
		String conPath = request.getContextPath(); // ch18/
		String command = uri.substring(conPath.length());
		System.out.println(uri);
		System.out.println(conPath);
		System.out.println(command);
		String viewPage = null; // 뷰단 이름
		Service service = null;
		if(command.equals("/insert.do")) {
			service = new InsertService();//insert 로직 수행할 객체 생성
			service.execute(request, response);//객체이름.메소드()
			request.setAttribute("result", "insert 결과");
			//viewPage = "ex2/select.jsp"; // list 결과를 뿌릴 수 없다
			viewPage = "select.do";
		}else if(command.equals("/select.do")) {
			service = new SelectService();
			service.execute(request, response);
			request.setAttribute("list", "list 결과");
			viewPage = "ex2/select.jsp";
		}else if(command.equals("/delete.do")) {
			service = new DeleteService();
			service.execute(request, response);
			request.setAttribute("delete", "delete 결과");
			viewPage = "select.do";
		}else if(command.equals("/update.do")) {
			service = new UpdateService();
			service.execute(request, response);
			request.setAttribute("update", "update 결과");
			viewPage = "select.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
