package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.Book;
import com.lec.ch19.util.Paging;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;
	
	String backupPath = "D:/yujin/webPro/source/08.Spring/ch19_memberBookUp/src/main/webapp/bookImgFileUpload/";
	
	@Override
	public List<Book> mainList() {
		return bookDao.mainList();
	}

	@Override
	public int totCntBook() {
		return bookDao.totCntBook();
	}
	
	@Override
	public List<Book> bookList(String pageNum) {
		Paging paging = new Paging(bookDao.totCntBook(), pageNum);
		Book book = new Book();
		book.setStartRow(paging.getStartRow());
		book.setEndRow(paging.getEndRow());
		return bookDao.bookList(book);
	}

	@Override
	public Book getDetailBook(int bnum) {
		return bookDao.getDetailBook(bnum);
	}

	@Override
	public int registerBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		while(params.hasNext()){
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 첨부한 파일 이름과 같은 이름의 파일 서버 존재 여부
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버 파일 : "+ uploadPath + bimg[idx]);
					System.out.println("백업 파일 : "+ backupPath + bimg[idx]);
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result == true ? idx+"번째 백업 성공" : idx+"번째 백업 실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			idx++;
		} // while
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.registerBook(book);
	}

	@Override
	public int modifyBook(MultipartHttpServletRequest mRequest, Book book) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1, tempBimg2
		String[] bimg = new String[2];
		int idx = 0;
		while(params.hasNext()){
			String param = params.next();
			MultipartFile mFile = mRequest.getFile(param); // 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath + bimg[idx]).exists()) {
					// 첨부한 파일 이름과 같은 이름의 파일 서버 존재 여부
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
				}
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버 파일 : "+ uploadPath + bimg[idx]);
					System.out.println("백업 파일 : "+ backupPath + bimg[idx]);
					boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx]);
					System.out.println(result == true ? idx+"번째 백업 성공" : idx+"번째 백업 실패");
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			idx++;
		} // while
		book.setBimg1(bimg[0]);
		book.setBimg2(bimg[1]);
		return bookDao.modifyBook(book);
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
