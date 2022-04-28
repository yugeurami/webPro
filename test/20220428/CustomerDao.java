package quiz1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	private static CustomerDao INSTANCE = new CustomerDao();
	public static CustomerDao getInstance() {
		return INSTANCE;
	}
	public CustomerDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	// 회원가입
	public int Join(String ctel, String cname) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO CUSTOMER(CNO, CNAME, CTEL)" + 
					"    VALUES (CUSTOMER_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cname);
			pstmt.setString(2, ctel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return result;
	}
	// 전화번호 조회
	public ArrayList<CustomerDto> Search(String ctel) {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		CustomerDto customer = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNAME, CTEL, CPOINT" + 
				"    FROM CUSTOMER" + 
				"    WHERE CTEL LIKE '%'||?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ctel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String cname = rs.getString("cname");
				ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				customer = new CustomerDto(cname, ctel, cpoint);
				customers.add(customer);
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
	//전체 출력
	public ArrayList<CustomerDto> Output() {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		CustomerDto customer = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT CNAME, CTEL, CPOINT" + 
				"    FROM CUSTOMER";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String cname = rs.getString("cname");
				String ctel = rs.getString("ctel");
				int cpoint = rs.getInt("cpoint");
				customer = new CustomerDto(cname, ctel, cpoint);
				customers.add(customer);
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
}
