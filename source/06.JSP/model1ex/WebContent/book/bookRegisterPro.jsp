<%@page import="com.lec.dto.BookDto"%>
<%@page import="com.lec.dao.BookDao"%>
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
		String path = request.getRealPath("bookImg");
		int maxSize = 1024*1024*5; // 최대 업로드 용량이 5MB
		String[] bimages = {"", ""};
		MultipartRequest mRequest = null;			
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());			
			Enumeration<String> paramNames = mRequest.getFileNames(); 
			int idx = 0;
			while(paramNames.hasMoreElements()){
				String imgName = paramNames.nextElement(); 
				bimages[idx] = mRequest.getFilesystemName(imgName);
				idx++;
			}
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		//서버의 bookImg폴더 파일을 소스 폴더의 bookImg 폴더로 복사
		for(String imgName : bimages){
			if(imgName!=null){
				InputStream is = null;
				OutputStream os = null;
				File serverFile = new File(path+"/"+imgName);
				try{
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:/yujin/webPro/source/06.JSP/model1ex/WebContent/bookImg"+imgName);
					byte[] bs = new byte[(int)serverFile.length()];
					while(true){
						int readbyteCnt = is.read(bs);
						if(readbyteCnt==-1) break;
						os.write(bs, 0, readbyteCnt);
					}
				}catch(Exception e){
					System.out.println(e.getMessage());					
				} finally{
					if(os!=null) os.close();
					if(is!=null) is.close();
				}
			}
		}
		
		// 파일 첨부외 파라미터에서 입력된 정보 get
		String btitle =  mRequest.getParameter("btitle");
		int bid = 0;
		int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
		String bimg1 = bimages[1] == null ? "noImg.png" : bimages[1] ;
		String bimg2 = bimages[0] == null ? "nothing.png" : bimages[0];
		String bcontent = mRequest.getParameter("bcontent");
		int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));;
		Date brdate = null;
		BookDao dao = BookDao.getInstance();
		BookDto dto = new BookDto(bid, btitle, bprice, bimg1, bimg2, bcontent, bdiscount, brdate);
		int result = dao.insertBook(dto);
		if(result == BookDao.SUCCESS){
	%>
		<script>
			alert('책 등록이 성공적으로 이루어졌습니다');
			history.back();
		</script>
	<%
		}else{
	%>
		<script>
			alert('책 등록에 실패했습니다');
			location.href="book_list.jsp";
		</script>
	<%
		}
	%>
</body>
</html>