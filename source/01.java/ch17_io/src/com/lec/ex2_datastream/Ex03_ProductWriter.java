package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex03_ProductWriter { // n을 입력할 때까지 재고(상품명,가격,재고량)을 입력받아 파일 출력

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String answer;
		OutputStream os = null;
		DataOutputStream dos = null;
		try {
			os = new FileOutputStream("src\\com\\lec\\ex2_datastream/product.dat",true);
			dos = new DataOutputStream(os);
			while(true) {
				System.out.print("입력할 재고가 더 있나요?(Y/N)");
				answer = sc.next();
				if(answer.equalsIgnoreCase("n")) {
					break;
				} else if(answer.equalsIgnoreCase("y")) { // 상품명, 가격, 재고량을 파일로 출력
					System.out.print("상품명은? ");
					dos.writeUTF(sc.next());
					System.out.print("가격은? ");
					dos.writeInt(sc.nextInt());
					System.out.print("재고수량은? ");
					dos.writeInt(sc.nextInt());
				} else {
					continue;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(dos!=null) {
				dos.close();
				}
				if(os!=null) {
					os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}
}
