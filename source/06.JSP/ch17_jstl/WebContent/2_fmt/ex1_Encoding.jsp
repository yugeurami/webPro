<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<body>
	<fmt:requestEncoding value="utf-8"/> <%-- request.setCharacterEncoding("utf-8"); --%>	
	<h1>이름 : ${param.name }<%-- <%=request.getParameter("name") %> --%></h1>
</body>
</html>