<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath}/css/style.css" rel="stylesheet">
	<style></style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<form action="${conPath }/boardModify.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="oldfilename" value="${content.ffilename }">
		<input type="hidden" name="fid" value="${content.fid }">
		<table>
			<caption><h2>${content.fid }번 글 수정</h2></caption>
			<tr>
				<th>제목</th>
				<td><input type="text" name="ftitle" required="required" value="${content.ftitle }"></td>
			</tr>
			<tr>
				<th>본문</th>
				<td><textarea rows="5" cols="20" name="fcontent">${content.fcontent }</textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>${content.ffilename }<input type="file" name="ffilename"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="작성 완료" class="btn">
					<input type="reset" value="초기화" class="btn">
					<input type="button" value="목록" class="btn" onclick="location='${conPath}/boardList.do?pageNum=${param.pageNum }'">
				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>