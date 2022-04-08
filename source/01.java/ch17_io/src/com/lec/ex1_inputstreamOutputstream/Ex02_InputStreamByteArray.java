package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// (1) 파일을 연다 
// (2) 데이터를 읽는다 : 	read() 1byte씩 읽는다. 속도가 느림
//					read(byte[]) byte[]만큼 읽기
// (3) 파일 닫는다
public class Ex02_InputStreamByteArray {

	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. 파일연다
			byte[] bs = new byte[10];
			while(true) { // 2. 파일 읽는다
				int readByteCount = is.read(bs);// 10 byte씩 읽기
				if(readByteCount==-1) break; // 파일 끝인지 여부
				for(int i = 0 ; i<readByteCount ; i++) { // 10 byte 미만인 경우도 있음으로 확장 for문이 아니라 일반 for문 사용
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(is != null) is.close(); // 3. 파일 닫기
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
