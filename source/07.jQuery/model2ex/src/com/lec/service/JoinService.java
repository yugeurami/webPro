package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class JoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fileUpFolder");
		int maxSize = 1024*1024; // 사진 업로드 제한 용량 : 1MB
		String mphoto = ""; // 첨부된 파일이 저장된 이름
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());			
			Enumeration<String> params = mRequest.getFileNames(); 
			String param = params.nextElement(); 
			mphoto = mRequest.getFilesystemName(param);
			
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			Date mbirth = null;
			if(mphoto == null){
				mphoto = "NOIMG.JPG";
			}
			if(!mRequest.getParameter("tempbirth").equals("")) {
				mbirth = Date.valueOf(mRequest.getParameter("mbirth"));
			}
			String maddress = mRequest.getParameter("maddress");
			MemberDao dao = MemberDao.getInstance();
			MemberDto dto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			int result = dao.join(dto);
			if(result == MemberDao.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("mid", mid);
				request.setAttribute("joinResult", "회원가입 성공");
			} else {
				request.setAttribute("joinErrorMSG", "정보가 너무 길어서 회원가입 실패");
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		File serverFile = new File(path + "/" + mphoto);
		if(!mphoto.equals("NOIMG.JPG")) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\yujin\\webPro\\source\\07.jQuery\\model2ex\\WebContent\\fileUpFolder\\"+mphoto); 
				byte[] bs = new byte[(int)serverFile.length()];
				while(true) {
					int readByteCnt = is.read(bs);
					if(readByteCnt == -1) {
						break;
					}
					os.write(bs, 0, readByteCnt);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) os.close();
					if(is!=null) is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
