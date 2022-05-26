<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% // 특정 세션 속성값 가져오기
		String sessionName = (String)session.getAttribute("sessionName");
		Integer myNum = (Integer)session.getAttribute("myNum");
		out.println("sessionName : "+ sessionName + "<br>");
		out.println("myNum : "+ myNum + "<br>");
		out.println("id : " + session.getAttribute("id")+"<br>"); // 추가한 속성이 없을 경우 null
		
		// 모든 세션 속성 리스트 출력
		out.println("<h3>모든 세션 속성들 list</h3>");
		Enumeration<String> sAttrNames = session.getAttributeNames();
		int cnt = 0;
		while(sAttrNames.hasMoreElements()){
			String sname = sAttrNames.nextElement(); // 세션(속성) 이름
			String svalue = session.getAttribute(sname).toString(); // 세션(속성)값
			out.println(sname + "(세션이름) / "+ svalue + "(세션값)<br>");
			cnt++;
		}
		if(cnt==0){
			out.println("추가된 세션 속성이 없습니다");
		}
		
		//특정 세션 삭제하기(로그아웃시 사용)
		session.removeAttribute("myNum"); // myNum 세션 속성 삭제
		out.println("<h3>myNum 세션 삭제 후 세션 속성 list</h3>");
		sAttrNames = session.getAttributeNames();
		cnt = 0;
		while(sAttrNames.hasMoreElements()){
			String sname = sAttrNames.nextElement(); // 세션(속성) 이름
			String svalue = session.getAttribute(sname).toString(); // 세션(속성)값
			out.println(sname + "(세션이름) / "+ svalue + "(세션값)<br>");
			cnt++;
		}
		if(cnt==0){
			out.println("추가된 세션 속성이 없습니다");
		}
		
		//모든 세션 삭제하기
		session.invalidate(); // setAttribute했던 모든 속성값 다 삭제
		if(request.isRequestedSessionIdValid()){//유효한 세션 속성이 있는 지 여부
			out.print("session vaild<br>");
		}else{
			out.print("session invaild<br>");
		}
		out.println("<h3>세션ID : "+ session.getId() + "</h3>");
		out.println("<h3>세션의 유효시간 : " + session.getMaxInactiveInterval()+"</h3>");
	%>
	
</body>
</html>