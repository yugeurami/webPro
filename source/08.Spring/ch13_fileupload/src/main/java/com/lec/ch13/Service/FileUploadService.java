package com.lec.ch13.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUploadService {
	public boolean fileUp(MultipartHttpServletRequest mRequest, ModelAndView mav) {
		boolean isUpload = false;
		// 업로드 된 파일명 받아, 서버에 업로드, 프로젝트 폴더에 복사
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:/yujin/webPro/source/08.Spring/ch13_fileupload/src/main/webapp/upload/";
		String[] filenames = new String[3];
		int i = 0;
		Iterator<String> params = mRequest.getFileNames(); // file1, file2, file3
		while(params.hasNext()) {
			String param = params.next();
			System.out.println(i + "번째 파라미터 이름 : " + param);
			MultipartFile mFile = mRequest.getFile(param);
			filenames[i] = mFile.getOriginalFilename(); // param으로 첨부한 file의 오리지널 file명
			if(filenames!=null && !filenames[i].equals("")) { // 첨부한 파일이 있을 경우
				if(new File(uploadPath + filenames[i]).exists()) { 
					filenames[i] = System.currentTimeMillis() + filenames[i];
				}// 중복된 file명이 있을 경우 이름 변경
				try {
					mFile.transferTo(new File(uploadPath + filenames[i]));
					System.out.println("서버에 저장된 파일 : " + uploadPath + filenames[i]);
					System.out.println("백업 복사 파일 : " + backupPath + filenames[i]);
					isUpload = fileCopy(uploadPath + filenames[i], backupPath + filenames[i]);
				}catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}else {
				System.out.println(i+"번째는 파일 첨부 안함 ");
				isUpload = true;
			}
			i++;
		}
		mav.addObject("filenames", filenames);
		return isUpload;
	}
	
	private boolean fileCopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		// 복사
		FileInputStream is = null;
		FileOutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return isCopy;
	}
}
