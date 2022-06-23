package com.lec.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;
import com.lec.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("freeBoardUp");
		int maxSize = 1024*1024; // 사진 업로드 제한 용량 : 1MB
		String ffilename = ""; // 첨부된 파일이 저장된 이름
		String oldfilename = "";
		String fip = request.getRemoteAddr();
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());			
			Enumeration<String> params = mRequest.getFileNames(); 
			String param = params.nextElement(); 
			oldfilename = mRequest.getParameter("oldfilename");
			ffilename = mRequest.getFilesystemName(param);
			System.out.println("파일이름"+ffilename);
			BoardDao dao = BoardDao.getInstance();
			int fid = Integer.parseInt(request.getParameter("fid"));
			String ftitle = mRequest.getParameter("ftitle");
			String fcontent = mRequest.getParameter("fcontent");
			BoardDto dto = new BoardDto(fid, null, null, ftitle, fcontent, ffilename, null, 0, 0, 0, 0, fip);
			System.out.println(dto);
			int result = dao.modify(new BoardDto(fid, null, null, ftitle, fcontent, ffilename, null, 0, 0, 0, 0, fip));
			request.setAttribute("modifyResult", result);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(ffilename == null || ffilename == oldfilename) {
			File serverFile = new File(path + "/" + ffilename);
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(serverFile);
				os = new FileOutputStream("D:\\yujin\\webPro\\source\\07.jQuery\\model2ex\\WebContent\\freeBoardUp\\"+ffilename); 
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
