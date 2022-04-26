package com.lec.ex4_supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class SuperDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	private static SuperDao INSTANCE;
	public static SuperDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new SuperDao();
		}
		return INSTANCE;
	}
	private SuperDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//고객등급 리스트
	public Vector<String> levelList(){
		Vector<String> levels = new Vector<String>();
		levels.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT LNAME FROM LEVELGRADE";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				levels.add(rs.getString("lname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return levels;
	}
	//아이디 검색
	
}
