package com.lec.ex4_object;

public class Point3DMain {

	public static void main(String[] args) throws CloneNotSupportedException {
		Point3D p1 = new Point3D(2.0, 5.0, 3.0);
		Point3D p2 = (Point3D) p1.clone();
		System.out.println(p1);
		System.out.println(p2);
		if(p1!=p2 && p1.equals(p2)) {
			System.out.println("복제성공");
		}else {
			System.out.println("복제실패");
		}
	}

}
