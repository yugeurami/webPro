package com.lec.ex3_shape;

import com.lec.cons.Constant;

public class Circle extends Shape {
	private int r; //반지름
	
	public Circle() {	}
	public Circle(int r) {
		this.r = r;
	}

	@Override
	public double computeArea() {
		return Constant.PI*r*r;
	}

}
