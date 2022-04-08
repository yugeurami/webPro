package com.lec.ex4_object;

public class Point3D implements Cloneable {
	private double x;
	private double y;
	private double z;
	
	public Point3D() {
	}

	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Point3D) {
			Point3D tempObj = (Point3D)obj;
			boolean xChk = x == tempObj.x;
			boolean yChk = y == tempObj.y;
			boolean zChk = z == tempObj.z;
			return xChk && yChk && zChk;
		}else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "[" + x +","+y +"," +z +"]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
