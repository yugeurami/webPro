<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<% String numStr = request.getParameter("num");// null 이거나 숫자 스트링%> 
	<fieldset>
		<legend>숫자입력</legend>
		<form>
			<label for="num">숫자 : </label>
			<input type="number" name="num" id="num" value="<%if(numStr!=null) out.print(numStr); %>">
			<input type="submit" value="누적"> 
		</form>
	</fieldset>
	<%	int sum = 0;
		if(numStr==null || numStr.equals("")){
	%>
	<script>
		alert('수를 입력해주세요!');
	</script>
	<% out.println("");
		} else{
			int num = Integer.parseInt(numStr);
			if(num>0){
				for(int i = 1 ; i<=num ; i++){
					sum += i;
				}
				out.println("<h2>1부터 "+num+"까지 누적합 : "+sum+"</h2>");			
			}else{
	%>
	<script>
		alert('0보다 큰 수를 입력해주세요!');
	</script>
	<% out.println("");
			}
		}
	%>
</body>
</html>