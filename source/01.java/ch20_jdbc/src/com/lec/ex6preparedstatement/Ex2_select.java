package com.lec.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 사용자로부터 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력하시오
public class Ex2_select {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT EMPNO, ENAME, JOB, SAL" + 
				"    FROM EMP E, DEPT D" + 
				"    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER(?)";
		System.out.print("검색하실 부서 명은? : ");
		String dname = sc.next();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(dname+" 부서의 사원 정보");
				System.out.println("사번\t이름\t직책\t\t급여");
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					if(job.length()<8) {
						System.out.printf("%d\t%s\t%s\t\t%d\n", empno, ename, job, sal);
					} else {
						System.out.printf("%d\t%s\t%s\t%d\n", empno, ename, job, sal);
					}
				}while(rs.next());
			}else {
				System.out.println(dname+" 부서에 사원이 존재하지 않습니다");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {}
	}
	sc.close();
	}
}
