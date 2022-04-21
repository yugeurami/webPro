package com.lec.ex3insert;
// 부서 번호를 입력받아 중복체크 후 입력 진행
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDept2 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			while(true){
				System.out.print("입력할 부서 번호는 ");
				int deptno = scanner.nextInt();
				String sql1 = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO="+deptno;
				rs = stmt.executeQuery(sql1);
				rs.next();
				int result = rs.getInt("cnt");
				if(result != 0) {
					System.out.println("이미 존재하는 부서번호입니다");
					rs.close();
					continue;
				}	
				System.out.print("입력할 부서명은 ");
				String dname = scanner.next();
				System.out.print("입력할 부서 위치는 ");
				String loc = scanner.next();
				String sql2 = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				result = stmt.executeUpdate(sql2);
				if(result > 0) {
					System.out.println("입력완료");
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL오류:"+e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		scanner.close();
	}

}
