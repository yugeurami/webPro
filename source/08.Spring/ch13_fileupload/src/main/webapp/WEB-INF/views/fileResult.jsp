<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FileResult</title>
</head>
<body>
	<h2>File Upload Result : ${fileResult }</h2>
	<p>file1 : ${filenames[0] }</p>
	<p>file2 : ${filenames[1] }</p>
	<p>file3 : ${filenames[2] }</p>
	<c:forEach var="i" begin="0" end="2">
		<c:if test="${not empty filenames[i] }">
			<img src="${conPath }/upload/${filenames[i] }" width="500"><br>
		</c:if>
		<c:if test="${empty filenames[i] }">
			${i+1 }번째 첨부파일 첨부 안 함<br>
		</c:if>
	</c:forEach>
</body>
</html>