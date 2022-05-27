<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="s" class="com.lec.ex.Student" scope="request"/>
	<h2>입력된 학생정보</h2>
	<p>학번 : <jsp:getProperty property="snum" name="s"/> </p>
	<p>이름 : <jsp:getProperty property="name" name="s"/></p>
	<p>학년 : <jsp:getProperty property="grade" name="s"/></p>
	<p>반 : <jsp:getProperty property="className" name="s"/></p>	
	<p>점수 : <jsp:getProperty property="score" name="s"/></p>	
</body>
</html>