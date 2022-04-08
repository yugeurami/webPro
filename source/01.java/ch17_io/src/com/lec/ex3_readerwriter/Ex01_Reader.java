package com.lec.ex3_readerwriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {

	public static void main(String[] args) {
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");//1. 파일연다
			while(true) { // 2. 데이터를 읽는다
				int i = reader.read();
				if(i==-1) {
					break;
				}
				System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
				
			}
		}
	}
}
