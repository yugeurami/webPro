<%@page import="com.lec.dto.CustomerDto"%>
<%@page import="com.lec.dto.FileboardDto"%>
<%@page import="com.lec.dao.FileboardDao"%>
<%@page import="java.sql.Date"%>
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
		request.setCharacterEncoding("utf-8"); 
		String fip = request.getRemoteAddr();
		String path = request.getRealPath("fileboardUpload");
		int maxSize = 1024*1024*10; 
		String ffilename = "";
		MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());			
		try{
			Enumeration<String> paramNames = mRequest.getFileNames(); 
			String param = paramNames.nextElement(); 
			ffilename = mRequest.getFilesystemName(param);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(ffilename!=null){
			InputStream is = null;
			OutputStream os = null;
			File serverFile = new File(path+"/"+ffilename);
			try{
				if(serverFile.exists()){
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:/yujin/webPro/source/06.JSP/model1ex/WebContent/fileboardUpload/"+ffilename);
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int readbyteCnt = is.read(bs);
						if(readbyteCnt== -1) break;
						os.write(bs, 0, readbyteCnt);
					}
				}
			}catch(Exception e2){
				System.out.println(e2.getMessage());					
			} finally{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}
		}				
		CustomerDto customer = (CustomerDto)(session.getAttribute("customer"));
		int fnum = Integer.parseInt(mRequest.getParameter("fnum"));
		int pageNum = Integer.parseInt(mRequest.getParameter("pageNum"));
		String cid = customer.getCid();
		String fsubject = mRequest.getParameter("fsubject");
		String fcontent = mRequest.getParameter("fcontent");
		String fpw = mRequest.getParameter("fpw");
		if(ffilename == null){
			ffilename = mRequest.getParameter("dbfile");
		}
		FileboardDao dao = FileboardDao.getInstance();
		FileboardDto dto = new FileboardDto(fnum, cid, fsubject, fcontent, ffilename, fpw, 0, 0, 0, 0, fip, null);
		int result = dao.updateContent(dto);
		if(result == FileboardDao.SUCCESS){
	%>
		<script>
			alert('글 수정이 성공적으로 이루어졌습니다');
			location.href="fileboardList.jsp?pageNum=<%=pageNum%>";
		</script>
	<%
		}else{
	%>
		<script>
			alert('글 수정에 실패했습니다');
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>