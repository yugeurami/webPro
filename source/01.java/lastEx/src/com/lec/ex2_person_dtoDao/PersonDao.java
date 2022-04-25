package com.lec.ex2_person_dtoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

// 입력, 직업별 조회, 전체조회, 직업리스트
public class PersonDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	private static PersonDao INSTANCE;
	public static PersonDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new PersonDao();
		}
		return INSTANCE;
	}
	private PersonDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}		
	} // 생성자
	// 1번 입력 (매개변수 dto, return SUCCESS/FAIL)
	public int insertPerson(PersonDto dto) {
		int result = FAIL;
		//dto안의 값을 db에 insert(2~7단계)
		Connection 			conn = null;
		PreparedStatement 	pstmt = null;
		String sql = "INSERT INTO PERSON "
					+ "VALUES (PERSON_NO_SQ.NEXTVAL, ?, "
					+ "(SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPname());
			pstmt.setString(2, dto.getJname());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
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
	// 2번 입력(매개변수 jname, return Arraylist<PersonDto>)
	public ArrayList<PersonDto> selectJname(String jname){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// 직업별 조회 결과를 dtos에 add
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, PNAME||'('||PNO||'번)' NAME, JNAME, KOR, ENG, MAT, SUM" + 
				"    FROM (SELECT P.*, JNAME, (KOR+ENG+MAT) SUM" + 
				"                FROM PERSON P, JOB J" + 
				"                WHERE P.JNO=J.JNO AND JNAME=?" + 
				"                ORDER BY SUM DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rank = rs.getInt("rank");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				dtos.add(new PersonDto(rank, name, jname, kor, eng, mat, sum));
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
		
		return dtos;
	}
	// 3번 전체 조회(return Arraylist<PersonDto>)
	public ArrayList<PersonDto> selectAll(){
		ArrayList<PersonDto> dtos = new ArrayList<PersonDto>();
		// 전체 조회 결과를 dtos에 add
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, PNAME||'('||PNO||'번)' NAME, JNAME, KOR, ENG, MAT, SUM\r\n" + 
				"    FROM (SELECT P.*, JNAME, (KOR+ENG+MAT) SUM\r\n" + 
				"                FROM PERSON P, JOB J \r\n" + 
				"                WHERE P.JNO=J.JNO ORDER BY SUM DESC)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setRank(rs.getInt("rank"));
				dto.setPname(rs.getString("name"));
				dto.setJname(rs.getString("jname"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setSum(rs.getInt("sum"));
				dtos.add(dto);
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
		return dtos;
	}
	// 4번 직업명 리스트 조회 (return Vector<String>
	public Vector<String> jnameList(){
		Vector<String> jnames = new Vector<String>();
		jnames.add(""); // 0번째 인덱스
		// 직업명리스트를 db에서 검색한 후 jnames에 add
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT JNAME FROM JOB";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jnames.add(rs.getString("jname"));
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
		return jnames;
	}
}//클래스
