package com.mega.lect;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hiddenParam = request.getParameter("hiddenParam");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String birth = request.getParameter("birth");
		Date birth2 = null ;
		Timestamp birth3 = null;
		if(birth!="") {
			birth2 = Date.valueOf(birth);
			birth3 = Timestamp.valueOf(birth+" 00:00:00");
		}
		String[] hobby = request.getParameterValues("hobby");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String[] mailSend = request.getParameterValues("mailSend");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link href=\"css/join.css\" rel=\"stylesheet\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<div id='joinFrom_wrap'>");
		out.println("<div id='join_title'>회원가입정보</div>");
		out.println("<h2>hiddenParam = "+hiddenParam+"</h2>");
		out.println("<h2>이름 : "+name+"</h2>");
		out.println("<h2>아이디 : "+id+"</h2>");
		out.println("<h2>비밀번호 : ");
		for(int i = 0 ; i<pw.length(); i++) {
			out.println('*');
		}
		out.println("</h2>");
		out.println("<h2>생년월일 : "+birth+"</h2>");
		out.println("<h2>생년월일2(java.sql.Date) : "+birth2+"</h2>");
		out.println("<h2>생년월일3(java.sql.Timestamp) : "+birth3+"</h2>");
		out.println("<h2>취미 : ");
		if(hobby!=null) {
			for(int j = 0; j<hobby.length; j++) {
				if(j == hobby.length-1) {
					out.println(hobby[j]);
				}else {
					out.println(hobby[j]+", ");
				}
			}
		} else {
			out.println("선택된 취미가 없음");
		}
		out.println("<h2>성별 : "+gender+"</h2>");
		out.println("<h2>이메일 : "+email+"</h2>");
		out.println("<h2>메일 수신 동의 : "+ Arrays.deepToString(mailSend)+"</h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
