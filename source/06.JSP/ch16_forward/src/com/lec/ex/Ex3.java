package com.lec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0;
		for(int i = 1 ; i<=su; i++){
			sum += i ;
		}
		request.setAttribute("sum", sum);
		RequestDispatcher dispacter = request.getRequestDispatcher("1_dispatcher/ex3_suView.jsp");
		dispacter.forward(request, response);
	}
	
	
}
