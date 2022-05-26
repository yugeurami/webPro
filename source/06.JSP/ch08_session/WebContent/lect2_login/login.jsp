<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<%
	String msg = request.getParameter("msg");
	if(msg!=null && msg.equals("id")){
%>
	<script>
		alert('id를 확인해주세요');
	</script>
<%
	} else if(msg!=null && msg.equals("pw")){
%>
	<script>
		alert('pw를 확인해주세요');
	</script>
<%
	}
	if(session.getAttribute("name")!=null){
		response.sendRedirect("welcome.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div>
		<form action="loginOk.jsp" method="post">
			<br>
			<table>
				<tr>
					<th><label for="id">아이디</label></th>
					<td><input type="text" name="id" id="id" required="required" autofocus="autofocus"
							value="<%
										String id = (String)session.getAttribute("id");
										if(id!=null){
											out.print(id);
										}
									%>"></td>
				</tr>
				<tr>
					<th><label for="pw">패스워드</label></th>
					<td><input type="password" name="pw" id="pw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>