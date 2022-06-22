<%@page import="com.lec.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&display=swap');
	</style>
	<link href="${conPath }/css/header.css" rel="stylesheet">
</head>
<body>
	<header>
		<div class="nav">
			<ul>
				<li><a href="#">고객센터</a></li>
				<li><a href="${conPath }/joinView.do">회원가입</a></li>					
				<li><a href="${conPath }/loginView.do">로그인</a></li>					
			</ul>
		</div>
		<div class="logo">
			<img src="https://pbs.twimg.com/profile_images/1268740402074419200/uxhIWach_400x400.png">
		</div>
		<div id="lnb">
			<ul>
					<li><a href="#">로그인 전 메뉴4</a></li>			
					<li><a href="#">로그인 전 메뉴3</a></li>			
					<li><a href="#">로그인 전 메뉴2</a></li>			
					<li><a href="#">로그인 전 메뉴1</a></li>			
			</ul>
		</div>
	</header>
</body>
</html>