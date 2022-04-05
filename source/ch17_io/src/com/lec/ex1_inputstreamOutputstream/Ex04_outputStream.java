package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// (1) 파일을 연다 (출력용 스트림 객체 생성) (2) write한다 (3)파일을 닫는다(스트림객체.close)
public class Ex04_outputStream {

	public static void main(String[] args) {
		OutputStream os = null;
		try {
			os = new FileOutputStream("txtFile/outTest.txt");
			String str = "Hello, Java\n이 시국에 모두 건강하세요";
			byte[] bs = str.getBytes(); // 스트링을 byte 배열로 바꾸는 함수
			os.write(bs);
			System.out.println("파일 출력 성공");
	
		} catch (FileNotFoundException e) { 
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			
		}
	}

}
