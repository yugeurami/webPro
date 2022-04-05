package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
// (1) 스트림 객체 생성 == 파일을 연다 (2) 데이터 쓴다 (3)스트림 객체 닫는다 == 파일을 닫는다
public class Ex01_DataOutputStream {

	public static void main(String[] args) {
		OutputStream 	 os  = null;
		DataOutputStream dos = null;
		try {
			os  = new FileOutputStream("txtFile/dataFile.dat", true); // 기본 스트림
			dos = new DataOutputStream(os); // 보조스트림은 기본 스트림을 통해서만 생성
			// 이름-학년-점수 write
			dos.writeUTF("홍길동"); // 스트링값 저장
			dos.writeInt(2);	  // int값 저장
			dos.writeDouble(90.5);// doouble값 저장
			
			dos.writeUTF("신길동"); // 스트링값 저장
			dos.writeInt(3);	  // int값 저장
			dos.writeDouble(99.5);// doouble값 저장
			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if(dos!=null)
				try {
					dos.close();
					if(os!=null) os.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}

	}

}
