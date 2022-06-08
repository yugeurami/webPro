<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		@import url('https://fonts.googleapis.com/css2?family=Barlow&family=Noto+Sans+KR:wght@300&display=swap');
	</style>
	<link href="<%=conPath %>/css/join.css" rel="stylesheet" type="text/css">
	<script>
		function infoConfirm(){
			if(frmJoin.cpw.value != frmJoin.pwChk.value){
				alert('비밀번호를 확인하세요');
				frmJoin.cpw.value = '';
				frmJoin.pwChk.value = '';
				frmJoin.cpw.focus();
				return false;
			}
		}
	</script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div id="joinForm_wrap">
		<form action="joinPro.jsp" method="post" name="frmJoin" onsubmit="return infoConfirm()">
			<div id="join_title">회원가입</div>
			<table>
				<tr>
					<th><label for="cid">아이디</label></th>
					<td>
						<input type="text" name="cid" class="cid" id="cid" autofocus="autofocus" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="cpw">비밀번호</label></th>
					<td>
						<input type="password" name="cpw" class="cpw" id="cpw" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="pwChk">비밀번호 확인</label></th>
					<td>
						<input type="password" name="pwChk" id="pwChk" class="pwChk" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="cname">이름</label></th>
					<td>
						<input type="text" name="cname" class="cname" id="cname" required="required">
					</td>
				</tr>
				<tr>
					<th><label for="ctel">전화</label></th>
					<td>
						<input type="tel" name="ctel" id="ctel" class="ctel" value="010" required="required" pattern="\d{2,3}[ .-]{0,1}\d{3,4}[ .-]{0,1}[0-9]{4}" 
                               title="전화번호 형식(000-0000-0000/xx-xxx-xxxx)을 지켜주세요">
					</td>
				</tr>
				<tr>
					<th><label for="cemail">이메일</label></th>
					<td>
						<input type="email" name="cemail" id="cemail" class="cemail" pattern="\w[a-zA-Z0-0_.]+@[a-zA-z]+(\.[a-z]+){1,2}" title="이메일을 확인해주세요">
					</td>
				</tr>
				<tr>
					<th><label for="caddress">주소</label></th>
					<td>
						<input type="text" name="caddress" class="caddress" id="caddress">
					</td>
				</tr>
				<tr>
					<th><label for="tempbirth">생년월일</label></th>
					<td>
						<input type="date" name="tempbirth" class="tempbirth" id="tempbirth" required="required">
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="cgender" value="m" id="m" checked="checked">
						<label for="m">남자</label>
						<input type="radio" name="cgender" value="f" id="f">
						<label for="f">여자</label>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="join" class="joinBtn_style">
						<input type="reset" value="reset" class="joinBtn_style">
						<input type="button" value="go back" class="joinBtn_style" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>