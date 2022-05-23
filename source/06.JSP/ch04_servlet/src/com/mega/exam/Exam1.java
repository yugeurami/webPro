package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam1")
public class Exam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] suStr = request.getParameterValues("su");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(suStr!=null) {
			for(int i=0; i<suStr.length; i++) {
				int su = Integer.parseInt(suStr[i]);
				out.println("<table><tr><td>"+su+"단</td></tr>");
				for(int j = 1; j<10; j++) {
					out.println("<tr><td>"+su+" * "+j+" = "+su*j+"</td></tr>");
				}
			}
		} else{
			out.println("<h4>선택한 수가 없습니다</h4>");
		}
		out.close();			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
