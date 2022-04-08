package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

// 파일에 저장된 재고들을 출력
public class Ex04_ProductPrint {

	public static void main(String[] args) {
		InputStream is = null;
		DataInputStream dis = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			is =  new FileInputStream("src\\com\\lec\\ex2_datastream/product.dat");
			dis = new DataInputStream(is);
			while(true) {
				String name = dis.readUTF();
				int price = dis.readInt();
				int ps = dis.readInt();
				products.add(new Product(name, price, ps));
				
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("재고 데이터는 다음과 같습니다");
		} finally {
			try {
				if(dis!=null) {
					dis.close();
				}
				if(is !=null) {
					is.close();
				}
			} catch (Exception e2) {}
		}
		if(products.isEmpty()) {
			System.out.println("입력된 재고가 없습니다");
		}else {
			System.out.println("물품명\t가격\t수량\t");
			for(Product product : products) {
				System.out.println(product);
			}
			System.out.println("이상 물품 "+products.size()+"가지 입력됨");
		}
	}
}
