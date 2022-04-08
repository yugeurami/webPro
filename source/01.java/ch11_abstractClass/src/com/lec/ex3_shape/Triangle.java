package com.lec.ex3_shape;

public class Triangle extends Shape {
	private int w; // 밑변
	private int h; // 높이
	
	public Triangle() {	}
	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public double computeArea() {
		return w*h*0.5;
	}

}
