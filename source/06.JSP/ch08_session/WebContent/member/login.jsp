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
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&display=swap');
	</style>
	<link href="<%=conPath %>/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="login">
		<form action="<%=conPath %>/member/loginPro.jsp" method="post">
			<table>
				<tr>
					<th><label for="id">id</label></th>
					<td>
						<input type="text" name="id" id="id" required="required" autofocus="autofocus"
							value="<%
										String id = (String)session.getAttribute("id");
										if(id!=null){
											out.print(id);
										}
									%>">
					</td>
					<td rowspan="2">
						<input type="submit" value="login">					
					</td>
				</tr>
				<tr>
					<th><label for="pw">password</label></th>
					<td><input type="password" name="pw" id="pw" required="required"></td>
				</tr>
				<tr>
					<td colspan="3" id="error">
					<%
						if(msg!=null){
					%>
								<p id="login_findIdPw" onclick="alert('아이디는 aaa/pw는 111');">
									아이디/비밀번호를 잊으셨나요?
								</p>
					<%
							}
					%>
					</td>
				<tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>