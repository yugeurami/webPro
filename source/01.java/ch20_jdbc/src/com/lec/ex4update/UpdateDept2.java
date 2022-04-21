package com.lec.ex4update;
// 수정하고자 하는 부서번호 입력 -> 존재하는 부서번호인지 체크
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDept2 {

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
			System.out.print("수정할 부서의 번호를 입력해주세요 ");
			int deptno = scanner.nextInt();
			String sql1 = "SELECT * FROM DEPT WHERE DEPTNO="+deptno;
			rs = stmt.executeQuery(sql1);			
			if(rs.next()) {
				System.out.print("수정할 부서명을 입력해주세요 ");
				String dname = scanner.next();
				System.out.print("수정할 위치를 입력해주세요 ");
				String loc = scanner.next();
				String sql2 = String.format("UPDATE DEPT SET DNAME='%s', LOC='%s' WHERE DEPTNO=%d", dname, loc, deptno);
				int result = stmt.executeUpdate(sql2);
				System.out.println(result>0 ? "수정 성공" : "수정 실패");
			
			}else {
				System.out.println("존재하지 않는 부서 번호입니다.");
				scanner.close();
				return;
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
		scanner.close();
		
	}

}
