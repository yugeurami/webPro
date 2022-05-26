<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		h3{
		width : 430px;
		margin : 0 auto;
		height : 600px;
		text-align : center;
		font-size : 1.5em;
		font-weight : bold;
		line-height : 660px;
		}
	</style>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<%	
		boolean outOk = false;
		Cookie[] cs = request.getCookies();
		if(cs!=null){
			for(Cookie c : cs){
				String cname = c.getName();
				String cvalue = c.getValue();
				if(cname.equals("id")){
					out.println("<h3>"+cname+"(쿠키이름) / " + cvalue + "(쿠키값)</h3>");
					outOk = true;
				}
			}
		}
		if(!outOk){
			out.println("<h3>생성된 쿠키가 없습니다(단, 시스템 쿠키는 제외)</h3>");			
		}
	%>
	<jsp:include page="footer.jsp"/>
</body>
</html>