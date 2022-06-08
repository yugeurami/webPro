<%@page import="java.util.Arrays"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
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
		int maxSize = 1024*1024*10;
		String[] filename = {"", "", ""};
		String[] originFilename = {"", "", ""};
		try{
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> paramNames = mRequest.getFileNames(); // 파라미터 이름들
			int idx = 0;
			while(paramNames.hasMoreElements()){
				String param = paramNames.nextElement(); // 파라미터 이름
				filename[idx] = mRequest.getFilesystemName(param); // 해당 파라미터 이름으로 저장된 파일 이름
				originFilename[idx] = mRequest.getFilesystemName(param);
				System.out.println(idx+"번째 파라미터 : "+param+", 저장파일 : "+filename[idx]+", 원 파일명 : "+originFilename[idx]);
				idx++;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		// 서버에 저장된 파일을 소스 폴더로 복사
		for(String f : filename){
			if(f!=null){
				// 파일 복사
				InputStream is = null;
				OutputStream os = null;
				try{
					File serverfile = new File(path+"/"+f);
					if(serverfile.exists()){
						is = new FileInputStream(serverfile);
						os = new FileOutputStream("D:/yujin/webPro/source/06.JSP/ch14_fileUp/WebContent/fileUpFolder/"+f); // 복사될 파일
						byte[] bs = new byte[(int)serverfile.length()];
						while(true){
							int nReadCnt = is.read(bs);
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
			}
		}
	%>
	<%= Arrays.toString(filename) %>
	<%= Arrays.toString(originFilename) %>
	<h2>파일 1 첨부 파일</h2>
	<h5><%=path %>/<%=filename[2] %></h5>
	<img src="../fileUpFolder/<%=filename[2] %>" alt="첫번째 첨부파일">
	
	<h2>파일 2 첨부 파일</h2>
	<h5><%=path %>/<%=filename[1] %></h5>
	<img src="../fileUpFolder/<%=filename[1] %>" alt="두번째 첨부파일">
	
	<h2>파일 3 첨부 파일</h2>
	<h5><%=path %>/<%=filename[0] %></h5>
	<img src="../fileUpFolder/<%=filename[0] %>" alt="세번째 첨부파일">
</body>
</html>