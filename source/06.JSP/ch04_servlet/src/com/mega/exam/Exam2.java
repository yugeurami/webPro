package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam2
 */
@WebServlet("/Exam2")
public class Exam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
//		String name = request.getParameter("name");
//		String address = request.getParameter("address");
//		response.setContentType("text/html; charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.println("<p>입력하신 이름 : "+name+"</p>");
//		out.println("<p>입력하신 주소 : "+address+"</p>");
//		out.close();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
//		doGet(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<p>입력하신 이름 : "+name+"</p>");
		out.println("<p>입력하신 주소 : "+address+"</p>");
		out.close();		
	}
}
