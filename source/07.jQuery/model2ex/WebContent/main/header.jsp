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
				<c:if test="${empty member && empty admin }">
					<li><a href="${conPath }/boardList.do">자유 게시판</a></li>
					<li><a href="${conPath }/joinView.do">회원가입</a></li>					
					<li><a href="${conPath }/loginView.do">로그인</a></li>					
				</c:if>
				<c:if test="${not empty member}">
					<li><a href="${conPath }/boardList.do">자유 게시판</a></li>
					<li id="withdrawal"><a href="">회원탈퇴</a></li>			
					<li><a href="${conPath }/logout.do">로그아웃</a></li>			
					<li><a href="${conPath }/modifyView.do">정보수정</a></li>			
					<li><a href="">${member.mname }님</a></li>			
				</c:if>
				<c:if test="${not empty admin}">
					<li><a href="${conPath }/boardList.do">자유 게시판</a></li>
					<li><a href="${conPath }/logout.do">관리자 모드 종료</a></li>			
					<li><a href="${conPath }/allView.do">회원정보 보기</a></li>			
					<li><a href="">관리자 ${admin.aname }님</a></li>			
				</c:if>
			</ul>
		</div>
		<div class="logo">
			<a href="${conPath }/main.do"><img src="https://pbs.twimg.com/profile_images/1268740402074419200/uxhIWach_400x400.png"></a>
		</div>
		<div id="lnb">
			<ul>
				<c:if test="${empty member && empty admin}">
					<li><a href="">로그인 전 메뉴 4</a></li>
					<li><a href="">로그인 전 메뉴 3</a></li>
					<li><a href="">로그인 전 메뉴 2</a></li>
					<li><a href="">로그인 전 메뉴 1</a></li>
				</c:if>
				<c:if test="${not empty member }">
					<li><a href="">로그인 후 메뉴 4</a></li>
					<li><a href="">로그인 후 메뉴 3</a></li>
					<li><a href="">로그인 후 메뉴 2</a></li>
					<li><a href="">로그인 후 메뉴 1</a></li>
				</c:if>
				<c:if test="${not empty admin }">
					<li><a href="">관리자 메뉴 4</a></li>
					<li><a href="">관리자 메뉴 3</a></li>
					<li><a href="">관리자 메뉴 2</a></li>
					<li><a href="">관리자 메뉴 1</a></li>
				</c:if>
			</ul>
		</div>
	</header>
</body>
</html>