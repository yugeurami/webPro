<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h3>ID : ${param.id }</h3>
	<h3>키우는 동물 : ${empty paramValues.pets ? "없습니다" : "" }
	 			   ${paramValues.pets[0]} 
	 			   ${paramValues.pets[1]} 
	 			   ${paramValues.pets[2]} 
	 			   ${paramValues.pets[3]} 
	 			   ${paramValues.pets[4]} 
	</h3>
</body>
</html>