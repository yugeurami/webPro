package com.lec.ex;
// 할당연산자: = += -= *= /= %=
public class Ex07 {

	public static void main(String[] args) {
		int n1 = 10;
		n1 += 10; // n1 = n1+10;
		System.out.println("n1 = "+n1);
		
		n1 -= 10; // n1 = n1-10;
		n1 *= 10; // n1 = n1*10;
		n1 /= 10; // n1 = n1/10;
		n1 %= 10; // n1 = n1%10;
		
		int n2 = n1 = 10;
		System.out.println("n1 = "+n1+"\t n2 = "+n2);
		
		// 모두 n1을 1 증가시킴
		n1 += 1; 
		n1++;
		++n1;
		n1 = n1+1;

	}
	

}