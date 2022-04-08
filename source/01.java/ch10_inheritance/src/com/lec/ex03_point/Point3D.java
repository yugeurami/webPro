package com.lec.ex03_point;
// Point3D p1 = new Point3D(20,10,5);
// p1. pointPrint();
public class Point3D extends Point {
	private int z;
	public Point3D() {	};
	public Point3D(int x, int y,int z) {
		setX(x);
		setY(y);
		this.z = z;
	} // p1.point3DPoint() syso(p1.info3DString()) syso(p1)
	public void point3DPrint() {
		System.out.println("3차원  좌표 : x="+getX()+", y="+getY()+", z="+z);
	}
	public String info3DString() {
		return "3차원  좌표 : x="+getX()+", y="+getY()+", z="+z;
	}
}
