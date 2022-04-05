package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_DataInputStream {

	public static void main(String[] args) {
		InputStream is = null;
		DataInputStream dis = null;
		try {
			is = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(is); // 보조스트림은 기본스트림을 통해서 생성
			while(true) {
				String name = dis.readUTF();
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.printf("%s는 %d학년 %f점\n", name, grade, score);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("이상 데이터 끝");
		} finally {
			if(dis!=null)
				try {
					dis.close();
					if(is!=null) is.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
		}
	}

}
