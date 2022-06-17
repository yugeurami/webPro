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
	<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
<body>
	<form action="${conPath }/reply.do" method="post">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="bgroup" value="${reply_view.bgroup }">
		<input type="hidden" name="bstep" value="${reply_view.bstep }">
		<input type="hidden" name="bindent" value="${reply_view.bindent }">
		<table>
			<caption>${reply_view.bid }번 글에 대한 답변 작성</caption>
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
					<input type="button" value="목록" class="btn" onclick="location='${conPath}/list.do?pageNum=${pageNum }'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>