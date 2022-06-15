<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<body>
	<%--
		if(1+2==3){
			out.println("1+2=3입니다");
		}else{
			out.println("1+2=3이 아닙니다");
		}
	--%>
	<c:if test="${1+2 eq 3 }">
		<h2>1+2=3입니다</h2>
	</c:if>
	<c:if test="${1+2 != 3 }" var="result" scope="page">
		<h2>1+2=3이 아닙니다</h2>
	</c:if>
	<h3>두번째 if문 조건에 대한 결과는 ${result }입니다</h3>
</body>
</html>