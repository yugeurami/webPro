package com.lec.ex;
// 증감연산: ++ --
public class Ex02 {

	public static void main(String[] args) {
		int n1 = 10;
		int n2 = ++n1; // n1값이 하나 증가
		
		System.out.println("n1="+n1+"\t n2="+n2);
		
		int n3 = 10;
		int n4 = n3--; // ;이후에 n3값이 하나 감소 
		
		System.out.println("n3="+n3+"\t n4="+n4);
		
		int n5 = 10;
		++n5; // n5값이 하나 증가
		int n6 = n5; // 증가된 n5값을 n6에
		
		System.out.println("n5="+n5+"\t n6="+n6);
		
		int n7 = 10;
		int n8 = n7; // n7의 값을 n8에 대응
		++n7; // n7값이 하나 증가
		
		System.out.println("n7="+ n7+"\t n8="+ n8);

	}

}
