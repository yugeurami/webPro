<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%
		String agree = request.getParameter("agree");
		if(agree.equals("y")){ //약관 동의한 경우(세션 속성값 받아 파일 저장, 일부 세션 남김)
			String id = (String)session.getAttribute("id");
			String pw = (String)session.getAttribute("pw");
			String name = (String)session.getAttribute("name");
			// 파일 저장(WebContent/WEB-INF/id.text)
			String filePath = "D:/yujin/webPro/source/06.JSP/ch08_session/WebContent/WEB-INF/id.txt";
			PrintWriter writer = new PrintWriter(filePath);
			writer.println("오늘은 DB에 insert대신 파일 출력");
			writer.println("아이디 : "+id);
			writer.println("비밀번호 : "+pw);
			writer.println("이름 : "+name);
			writer.close();
			session.removeAttribute("pw");
			session.removeAttribute("name");
			// 세션의 id 속성은 유지
			response.sendRedirect("result.jsp?msg=success");
		}else{ // 약관에 동의 하지 않은 경우 세션날림
			session.invalidate();
			response.sendRedirect("result.jsp?msg=fail");			
		}
	%>
</body>
</html>