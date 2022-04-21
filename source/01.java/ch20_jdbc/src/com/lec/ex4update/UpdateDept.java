package com.lec.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null; 
		Statement stmt = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			System.out.print("수정할 부서의 번호를 입력해주세요 ");
			int deptno = scanner.nextInt();
			//원래 입력할 부서번호가 있는 지 없는 지 체크해야함
			System.out.print("수정할 부서명을 입력해주세요 ");
			String dname = scanner.next();
			System.out.print("수정할 위치를 입력해주세요 ");
			String loc = scanner.next();
			String sql = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d", dname, loc, deptno);
			int result = stmt.executeUpdate(sql);
			System.out.println(result>0 ? "수정 성공" : "해당 부서는 존재하지 않음");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		scanner.close();
		
	}

}
