<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Detail</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<style>
		#content {
			width: 800px; height:350px;
			margin: 50px auto;
		}
		img{width: 100px;}
		table{
			width : 100%;
		}
		#info{
			height : 200px;
		}
	</style>
</head>
<body>
	<c:if test="${param.modifyResult  eq 1 }">
		<script> alert("도서 정보 수정이 성공했습니다");</script>
	</c:if>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
		<table>
			<tr>
				<th>책제목</th>
				<td>${bookDto.btitle }</td>
			</tr>
			<tr>
				<th>저자</th>
				<td>${bookDto.bwriter }</td>
			</tr>
			<tr>
				<th>출판일</th>
				<td>${bookDto.brdate }</td>
			</tr>
			<tr>
				<th colspan="2">책 소개</th>
			</tr>
			<tr id="info">
				<td colspan="2">
					<c:if test="${bookDto.bimg1 != 'noImg.png' }">
						<img src="${conPath }/bookImgFileUpload/${bookDto.bimg1}">
					</c:if>
					<c:if test="${bookDto.bimg2 != 'noImg.png' }">
						<img src="${conPath }/bookImgFileUpload/${bookDto.bimg2}">
					</c:if>
					<br>
					${bookDto.binfo }
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="location.href='book.do?method=list&pageNum=${param.pageNum }'">목록으로</button>
					<button onclick="location.href='book.do?method=modifyForm&bnum=${bookDto.bnum }&pageNum=${param.pageNum }'">도서 정보 수정</button>
				</td>
			</tr>
		</table>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>
