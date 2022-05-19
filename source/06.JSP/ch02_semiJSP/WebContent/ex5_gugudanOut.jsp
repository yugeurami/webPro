<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table{
			width : 200px;
			margin : 0 auto;
			text-align : center;
		}
		table caption {
			font-weight : bold;
			border-bottom : 1px solid gray;
		}
	</style>
</head>
<body>
	<%
		//내장 객체 request 이용하여 받은 파라미터 값은 String
		int su = Integer.parseInt(request.getParameter("su"));
	%>
	<table>
		<caption><%=su %>단 구구단 출력</caption>
		<%for(int i=1; i<10 ; i++){%>
		<tr>
			<td><%=su %>*<%=i %> = <%= su*i %></td>
		</tr>
		<%}%>
	</table>
</body>
</html>