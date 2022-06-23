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

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhoto");
		int maxSize = 1024*1024; // 사진 업로드 제한 용량 : 1MB
		String mphoto = ""; // 첨부된 파일이 저장된 이름
		HttpSession session = request.getSession();
		MemberDto mdto = (MemberDto) session.getAttribute("member");
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());			
			Enumeration<String> params = mRequest.getFileNames(); 
			String param = params.nextElement(); 
			mphoto = mRequest.getFilesystemName(param);
			
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			if(mpw.equals("")) {
				mpw = mdto.getMpw();
			}
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			Date mbirth = null;
			if(mphoto == null){
				mphoto = mdto.getMphoto();
			}
			if(!mRequest.getParameter("tempbirth").equals("")) {
				mbirth = Date.valueOf(mRequest.getParameter("tempbirth"));
			}else {
				mbirth = mdto.getMbirth();
			}
			String maddress = mRequest.getParameter("maddress");
			MemberDao dao = MemberDao.getInstance();
			MemberDto dto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
			int result = dao.modify(dto);
			if(result == MemberDao.SUCCESS) {
				session.setAttribute("member", dao.getMember(mid));
				request.setAttribute("modifyResult", "정보 수정 성공");
			} else {
				request.setAttribute("modifyErrorMSG", "정보가 너무 길어서 수정 실패");
			}			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		File serverFile = new File(path + "/" + mphoto);
		if(!mphoto.equals(mdto.getMphoto())) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\yujin\\webPro\\source\\07.jQuery\\model2ex\\WebContent\\memberPhoto\\"+mphoto); 
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
