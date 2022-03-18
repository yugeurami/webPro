package com.lec.ex;
// 논리연산자 : &&(AND) ||(OR)
public class Ex04 {
	public static void main(String[] args) {
		int i=1, j=10, h=10;
		
		//&&연산자 좌항이 false일 때는 우항 실행 안 함
		boolean result = ( (i>j) && (++j>h) );
		System.out.println("result="+result+"\t j="+j);
		
		result = ( (i<j) && (++j>h) ); 
		System.out.println("result="+result+"\t j="+j);
		
		//||연산자 좌항이 true일 땐 우항 실행 안 함
		result = (i<j) || (++j>h); 
		System.out.println("result="+result+"\t j="+j);
		
		result = (i>j) || (++j>h); 
		System.out.println("result="+result+"\t j="+j);
	}

}