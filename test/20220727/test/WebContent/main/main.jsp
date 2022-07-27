<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&family=Noto+Sans+KR:wght@300&display=swap');
	</style>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
	
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="mainForm_wrap">
		<h1>쇼핑몰 회원 관리 프로그램</h1>
		<h2>쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원 관리 프로그램을 작성하는 프로그램이다.</h2>
		<h3>프로그램 작성 순서</h3>
		<ol>
			<li>회원 정보 테이블을 생성한다.</li>
			<li>매출 정보 테이블을 생성한다.</li>
			<li>회원정보, 매출정보 테이블에 제시된 문제지의 참조 데이터를 추가 생성한다</li>
			<li>회원정보 입력 기능을 구현한다.</li>
			<li>회원 정보 조회 기능을 구현한다.</li>
			<li>회원 매출 정보 조회 기능을 구현한다.</li>
		</ol>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>