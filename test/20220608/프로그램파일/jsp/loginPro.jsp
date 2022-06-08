<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="com.lec.customer.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8");%>
	<%
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		CustomerDao dao = new CustomerDao();
		int result = dao.login(cid, cpw);
		if(result == CustomerDao.SUCCESS){
			CustomerDto customer = dao.getCustomer(cid);
			session.setAttribute("customer", customer);
			response.sendRedirect("main.jsp");
		}else{
			response.sendRedirect("login.jsp?msg=error");							
		}
	%>
</body>
</html>