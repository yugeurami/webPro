<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
	<%
		String deptnoStr = request.getParameter("deptno");
		if(deptnoStr==null){
			deptnoStr = "-1";
		}
		int deptno = Integer.parseInt(deptnoStr);
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DEPT";
	%>
	<form action="">
		부서번호
		<select name="deptno">
			<!-- DB에서 가져온 부서번호를 option에 추가 -->
			<%
				try{
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					if(rs.next()){
						do{
							int deptnoDB = rs.getInt("deptno");
							String dname = rs.getString("dname");
							if(deptno != deptnoDB){
								out.println("<option value='"+deptnoDB+"'>"+dname+"("+deptnoDB+")</option>");
							}else{
								out.println("<option value='"+deptnoDB+"' selected='selected'>"+dname+"("+deptnoDB+")</option>");								
							}
						}while(rs.next());
					}else{
						out.println("부서 정보가 없습니다");				
					}
			%>
		</select>
		<input type="submit" value="검색">
	</form>
	<%
		if(deptno!=-1){
	%>
	<table>
		<!-- 파라미터로 받은 부서번호의 사원정보 테이블에 추가 -->
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>직책</th>
			<th>상사사번</th>
			<th>입사일</th>
			<th>급여</th>
			<th>상여</th>
			<th>부서번호</th>
		</tr>
		<%		
				sql = "SELECT * FROM EMP WHERE DEPTNO="+deptno;
				rs = stmt.executeQuery(sql);
				if(rs.next()){
					do{
						int  empno			=	rs.getInt("empno");
					 	String ename		=	rs.getString("ename");
					 	String job			=	rs.getString("job");
					 	int mgr				=	rs.getInt("mgr");
					 	Timestamp hiredate	=	rs.getTimestamp("hiredate");
					 	int sal				=	rs.getInt("sal");		
					 	int comm			=	rs.getInt("comm");
					 	out.println("<tr><td>"+empno+"</td><td>"+ename+"</td><td>"+job+"</td><td>"+mgr+"</td><td>"+hiredate+"</td><td>"+sal+"</td><td>"+comm+"</td><td>"+deptno+"</td></tr>");
					}while(rs.next());
				}else{
					out.println("<tr><td colspan='8'>사원이 없습니다</td></tr>");
				}
			}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally{
				try{
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
					if(conn!=null) conn.close();
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}			
		%>
	</table>
</body>
</html>