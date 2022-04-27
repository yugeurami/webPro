package com.lec.ex4_supermarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.lec.ex3_student.StudentDto;

public class SuperDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	private static SuperDao INSTANCE = new SuperDao();
	public static SuperDao getInstance() {
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
	public SuperDto searchId(int cid) {
		SuperDto cus = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNAME, CTEL, CPOINT, CAMOUNT, LNAME," + 
				"    (SELECT HIGH - CAMOUNT FROM CUSTOMER C, LEVELGRADE L WHERE C.LNO+1=L.LNO AND C.LNO!=-1 AND CID = CS.CID) NEEDPAY" + 
				"    FROM CUSTOMER CS, LEVELGRADE LG" + 
				"    WHERE CS.LNO=LG.LNO AND CS.CID =" + cid;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String lname = rs.getString("lname");
				int needpay = rs.getInt("needpay");
				cus = new SuperDto(cid, cname, ctel, lname, cpoint, needpay, camount);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return cus;
	}
	//폰 뒤 4자리 검색
	public ArrayList<SuperDto> telSearch(String tel) {
		ArrayList<SuperDto> customers = new ArrayList<SuperDto>();
		SuperDto cus = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LG.LNAME," + 
				"    (SELECT HIGH - CAMOUNT FROM CUSTOMER C, LEVELGRADE L WHERE C.LNO+1=L.LNO AND C.LNO!=-1 AND CID = CS.CID) NEEDPAY" + 
				"    FROM CUSTOMER CS, LEVELGRADE LG" + 
				"    WHERE CS.LNO=LG.LNO AND CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String lname = rs.getString("lname");
				int needpay = rs.getInt("needpay");
				cus = new SuperDto(cid, cname, ctel, lname, cpoint, needpay, camount);
				customers.add(cus);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return customers;
	}
	//고객이름 검색
	public ArrayList<SuperDto> nameSearch(String cname) {
		ArrayList<SuperDto> customers = new ArrayList<SuperDto>();
		SuperDto cus = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LG.LNAME," + 
				"    (SELECT HIGH - CAMOUNT FROM CUSTOMER C, LEVELGRADE L WHERE C.LNO+1=L.LNO AND C.LNO!=-1 AND CID = CS.CID) NEEDPAY" + 
				"    FROM CUSTOMER CS, LEVELGRADE LG" + 
				"    WHERE CS.LNO=LG.LNO AND CNAME = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String lname = rs.getString("lname");
				int needpay = rs.getInt("needpay");
				cus = new SuperDto(cid, cname, ctel, lname, cpoint, needpay, camount);
				customers.add(cus);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return customers;
	}
	//포인트로 구매
	public int pointBuy(int cid, int pay) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + 
					"    SET CPOINT = CPOINT-?" + 
					"    WHERE CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pay);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return result;
	}
	//물품 구매
	public int buy(int cid, int pay) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = " UPDATE CUSTOMER" + 
				"    SET CAMOUNT = CAMOUNT + ?," + 
				"          CPOINT = CPOINT + ?*0.05," + 
				"          LNO = (SELECT L.LNO FROM CUSTOMER C, LEVELGRADE L WHERE CAMOUNT + ? BETWEEN LOW AND HIGH AND C.LNO!=-1 AND CID = ?)" + 
				"    WHERE CID =?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pay);
			pstmt.setInt(2, pay);
			pstmt.setInt(3, pay);
			pstmt.setInt(4, cid);
			pstmt.setInt(5, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return result;
	}
	// 등급별 출력
	public ArrayList<SuperDto> levelOutput(String lname) {
		ArrayList<SuperDto> customers = new ArrayList<SuperDto>();
		SuperDto cus = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT LG.LNAME, CID, CTEL, CNAME, CPOINT, CAMOUNT," + 
				"    (SELECT HIGH - CAMOUNT FROM CUSTOMER C, LEVELGRADE L WHERE C.LNO+1=L.LNO AND C.LNO!=-1 AND CID = CS.CID) NEEDPAY" + 
				"    FROM CUSTOMER CS, LEVELGRADE LG" + 
				"    WHERE CS.LNO=LG.LNO AND LG.LNAME = ?"+ 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				int needpay = rs.getInt("needpay");
				cus = new SuperDto(cid, cname, ctel, lname, cpoint, needpay, camount);
				customers.add(cus);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return customers;
	}
	// 전체출력
	public ArrayList<SuperDto> customerOutput() {
		ArrayList<SuperDto> customers = new ArrayList<SuperDto>();
		SuperDto cus = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LG.LNAME," + 
				"    (SELECT HIGH - CAMOUNT FROM CUSTOMER C, LEVELGRADE L WHERE C.LNO+1=L.LNO AND C.LNO!=-1 AND CID = CS.CID) NEEDPAY" + 
				"    FROM CUSTOMER CS, LEVELGRADE LG" + 
				"    WHERE CS.LNO=LG.LNO" + 
				"    ORDER BY CAMOUNT DESC";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				int camount = rs.getInt("camount");
				String lname = rs.getString("lname");
				int needpay = rs.getInt("needpay");
				cus = new SuperDto(cid, cname, ctel, lname, cpoint, needpay, camount);
				customers.add(cus);
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
		return customers;
	}
	//회원가입
	public int joinCustomer(String cname, String ctel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER(CID, CNAME, CTEL)" + 
				"    VALUES (CUSTOMER_CID_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			pstmt.setString(2, ctel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return result;
	}
	//번호 수정
	public int updateTel(String ctel, int cid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER" + 
				"    SET CTEL = ?" + 
				"    WHERE CID = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			pstmt.setInt(2, cid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return result;
	}
	//회원탈퇴
	public int deleteCustomer(String tel) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM CUSTOMER WHERE CTEL = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return result;
	}
}
