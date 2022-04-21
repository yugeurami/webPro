package com.lec.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//1. 사용자에게 부서이름을 입력 받아
//1-1 해당부서 번호가 존재할 경우 : 해당 부서 사원(사번, 이름, 급여, 급여등급)을 출력
//1-2 해당부서가 존재하지 않을 경우 : 없다고 출력
public class Ex3_selectDnameEmp {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null; 
		Statement stmt = null;	
		ResultSet rs = null; 
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서명은? ");
		String dname = sc.next();
		String sql1 = "SELECT * FROM DEPT WHERE DNAME = UPPER('"+dname+"')";
		sql1 = String.format("SELECT * FROM DEPT WHERE DNAME = UPPER('%s')", dname);
		String sql2 = String.format("SELECT EMPNO, ENAME, SAL, GRADE" + 
									"    FROM EMP E, SALGRADE, DEPT D" + 
									"    WHERE SAL BETWEEN LOSAL AND HISAL" + 
									"    AND E.DEPTNO=D.DEPTNO" + 
									"    AND DNAME= UPPER('%s')", dname);
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if(rs.next()) {
				System.out.println(dname+"부서");
				System.out.println("부서번호 : "+rs.getInt("deptno"));
				System.out.println("부서위치 : "+rs.getString("loc"));
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println("사번\t이름\t급여\t급여등급");
					do {
						System.out.print(rs.getInt("empno")+"\t");
						System.out.print(rs.getString("ename")+"\t");
						System.out.print(rs.getInt("sal")+"\t");
						System.out.print(rs.getInt("grade")+"\n");
					}while(rs.next());
				} else {
					System.out.println("해당 부서는 직원이 없습니다");
				}
			}else {
				System.out.println(dname+" 부서는 없습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		sc.close();
	}

}
