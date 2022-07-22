<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WRITE</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script>
		$(document).ready(function(){

		});
	</script>
</head>
<body>
	<form action="${conPath }/write.do" method="post">
		<table>
			<caption>원 글 작성</caption>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="bname" required="required"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="btitle" required="required"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="20" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성 완료" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" 
							onclick="location='${conPath}/list.do'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>