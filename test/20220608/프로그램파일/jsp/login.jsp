<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<%
	String msg = request.getParameter("msg");
	if(session.getAttribute("customer")!=null){
		response.sendRedirect("main.jsp");
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
		<form action="<%=conPath %>/customer/loginPro.jsp" method="post">
			<table>
				<tr>
					<th><label for="cid">id</label></th>
					<td>
						<input type="text" name="cid" id="cid" required="required" autofocus="autofocus"
							value="<%
										String cid = (String)session.getAttribute("cid");
										if(cid!=null){
											out.print(cid);
										}
									%>">
					</td>
					<td rowspan="2">
						<input type="submit" value="login">					
					</td>
				</tr>
				<tr>
					<th><label for="cpw">password</label></th>
					<td><input type="password" name="cpw" id="cpw" required="required"></td>
				</tr>
				<tr>
					<td colspan="3" id="error">
					<%
						if(msg!=null){
					%>
								<p id="login_findIdPw" onclick="#">
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