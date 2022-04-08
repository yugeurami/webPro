package com.lec.ex4_boxorrect;

public class BoxOrRect {
	private int width;
	private int height;
	private int depth; // box의 경우는 깊이, rect일 경우는 0
	private int volume; //box일 경우는 부피, rect일 경우는 넓이
	public BoxOrRect() {	} // 디폴트 생성자
	public BoxOrRect(int width, int height) { // rect일 경우
		this.width = width;
		this.height = height;
		volume = width*height;
	}
	public BoxOrRect(int width, int height, int depth) { // box일 경우
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width*height*depth;
	}
	public int getVolume() {
		return volume;
	}
	public void vPrint() {
		if(depth!=0) { //box
			System.out.println("부피는 "+volume);
		}else { //rect
			System.out.println("넓이는 "+volume);
		}
	}
}
