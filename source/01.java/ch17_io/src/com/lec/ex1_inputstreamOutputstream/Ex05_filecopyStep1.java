package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// (1) 스트림 객체(입력용, 출력용) (2) 읽고 쓴다 (3)파일 닫는다(스트림객체.close)
public class Ex05_filecopyStep1 {
	public static void main(String[] args) {
		InputStream  is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("D:\\yujin\\webPro\\monstaX.jpg"); //(1)
			os = new FileOutputStream("D:/yujin/webPro/monstaX_copy.jpg");
			int cnt = 0;
			while(true) { //(2)
				int i = is.read(); //1byte 읽기
				if(i==-1) break; // 파일의 끝인지 여부
				os.write(i);
				cnt++;
			}
			System.out.println(cnt+"번 while문 실행하여 힘들게 복사 성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) {
					os.close(); // 나중에 만든 객체를 먼저 닫는다
				}
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
