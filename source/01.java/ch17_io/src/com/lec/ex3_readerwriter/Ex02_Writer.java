package com.lec.ex3_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {

	public static void main(String[] args) {
		Writer writer = null;
		try {
			writer = new FileWriter("txtFile/outTest.txt", true); //(1)
			String msg = "\n\n추가한 텍스트 파일입니다. 안녕하세요";
			writer.write(msg);//(2)
			System.out.println("파일 출력 성공");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(writer!=null) {
					writer.close(); // (3)
				}
			} catch (Exception e2) {}
		}
	}
}
