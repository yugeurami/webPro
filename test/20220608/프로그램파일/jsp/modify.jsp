<%@page import="com.lec.customer.CustomerDto"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath%>/css/join.css" rel="stylesheet">
	<script>
		function infoConfirm(){
			if(modify_frm.cpw.value != modify_frm.pwChk.value){
				alert('새비밀번호를 확인하세요');
				modify_frm.cpw.value = '';
				modify_frm.pwChk.value = '';
				modify_frm.cpw.focus();
				return false;
			}
		}
	</script>
</head>
<body>
	<%! String cid, cname, ctel, cgender, cemail, caddress;
		Date cbirth;
	%>
	<% 
		CustomerDto customer = (CustomerDto)session.getAttribute("customer");
		if(customer==null){
			response.sendRedirect("login.jsp");
		}else{
			cid = customer.getCid();
			cname = customer.getCname();
			ctel = customer.getCtel();
			cgender = customer.getCgender();
			cemail = customer.getCemail();
			caddress = customer.getCaddress();
			cbirth = customer.getCbirth();
		}
	%>
	<jsp:include page="header.jsp"/>
	<div id="joinForm_wrap">
	<form action="modifyPro.jsp" method="post" name="modify_frm" onsubmit="return infoConfirm()">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="cid" class="cid" readonly="readonly" value="<%=cid %>"></td>
			</tr>
			<tr>
				<th>현재 비밀번호</th>
				<td><input type="password" name="oldPw" class="oldPw" required="required"></td>
			</tr>
			<tr>
				<th>새비밀번호</th>
				<td><input type="password" name="cpw" class="cpw" placeholder="비밀번호 수정 시에만 입력"></td>
			</tr>
			<tr>
				<th>새 비밀번호 확인</th>
				<td><input type="password" name="pwChk" class="pwChk"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="cname" class="cname" value="<%=cname %>" required="required"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="tel" name="ctel" class="ctel" value='<%=ctel%>' pattern="\d{2,3}[ .-]{0,1}\d{3,4}[ .-]{0,1}[0-9]{4}" 
                               title="전화번호 형식(000-0000-0000/xx-xxx-xxxx)을 지켜주세요" required="required">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="cemail" class="cemail" value='<%=cemail==null ? "" : cemail %>' pattern="\w[a-zA-Z0-0_.]+@[a-zA-z]+(\.[a-z]+){1,2}" title="이메일을 확인해주세요"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="caddress" class="caddress" value='<%= caddress==null ? "" : caddress%>'></td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td><input type="date" name="tempbirth" class="tempbirth" value='<%=cbirth%>' required="required"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<%if("m".equals(cgender)){ %>
						<input type="radio" name="cgender" value="m" checked="checked">남
						<input type="radio" name="cgender" value="f">여
					<%}else if("f".equals(cgender)){ %>
						<input type="radio" name="cgender" value="m" >남
						<input type="radio" name="cgender" value="f" checked="checked">여
					<%}%>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" class="joinBtn_style">
					<input type="reset" value="취소" class="joinBtn_style">
					<input type="button" value="뒤로가기" onclick="history.back()" class="joinBtn_style">	
				</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>