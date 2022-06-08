<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
		String path = request.getRealPath("fileUpFolder");
		int maxSize = 1024*1024*10; // 업로드 최대 용량 10MB
		String filename = ""; // 서버에 저장될 파일이름
		String originalFilename = ""; // 업로드한 오리지널 파일이름
		try{
			MultipartRequest multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			// DefaultFileRenamePolicy() : 서버에 같은 이름의 파일이 저장되어 있을 경우 rename해줌
			Enumeration<String> paramNames = multipartRequest.getFileNames(); // 파라미터 이름들
			String param = paramNames.nextElement(); // 파라미터 이름 하나 가져옴
			filename = multipartRequest.getFilesystemName(param); // 파일이 서버에 저장된 이름
			originalFilename = multipartRequest.getOriginalFileName(param); // 오리지널 파일 이름
			// 파일 첨부를 하지 않을 경우 filename과 originalFilename에는 null이 들어간다
			System.out.println("파라미터 이름 : "+param+" / 서버에 저장된 파일이름 : "+filename + " / 사용자가 업로드한 오리지널 파일이름 : "+originalFilename);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		// 서버 폴더에 업로드한 파일을 소스의 같은 이름의 폴더로 copy
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverfile = new File(path+"/"+filename);
			if(serverfile.exists()){ // 첨부한 파일의 존재여부 - 첨부하지 않았으면 파일 복사 안함
				is = new FileInputStream(serverfile); // 원본파일
				os = new FileOutputStream("D:/yujin/webPro/source/06.JSP/ch14_fileUp/WebContent/fileUpFolder/"+filename); // 복사될 파일
				byte[] bs = new byte[(int)serverfile.length()];
				while(true){
					int nReadCnt = is.read(bs); // 파일의 끝이 아닌 경우 읽어들인 byte수 : nReadCnt
					if(nReadCnt == -1) break;
					os.write(bs, 0, nReadCnt);
				}
				System.out.println("서버 첨부 & 복사 완료");
			}
		}catch(Exception e2){
			System.out.println(e2.getMessage());
		}finally{
			if(os!=null) os.close();
			if(is!=null) is.close();
		}
		if(filename!=null){ //첨부함%>
			<h3>첨부한 오리지널 파일 이름 : <%=originalFilename %></h3>
			<h3>서버에 저장된 파일 : <%=path %>/<%=filename %></h3>
			<img src="<%=conPath %>/fileUpFolder/<%=filename %>" alt="첨부파일">
<%		}else{
			out.println("<h2>파일을 첨부하지 않았습니다</h2>");
		}
	%>
</body>
</html>