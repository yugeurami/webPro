<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/style.css" rel="stylesheet">
</head>
<body>
	<% String num = request.getParameter("num");  %>
	<table>
		<caption><%=num %>번 글 삭제</caption>
		<tr>
			<td>
				<fieldset>
					<legend>삭제를 위해서는 비밀번호가 일치해야 합니다</legend>
					<form action="deletePro.jsp" method="post">
						<input type="hidden" name="num" value="<%=num%>">
						<p>비밀번호<input type="password" name="pw" required="required"></p>
						<p>
							<input type="submit" value="삭제" class="btn">
							<input type="reset" value="취소" class="btn">
							<input type="button" value="목록으로" class="btn" onclick="location.href='list.jsp'">
						</p>
					</form>
				</fieldset>
			</td>
		</tr>
	</table>
</body>
</html>