package com.lec.ex3_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class StudentDao {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public static int SUCCESS = 1;
	public static int FAIL = 0;
	private static StudentDao INSTANCE;
	public static StudentDao getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new StudentDao();
		}
		return INSTANCE;
	}
	private StudentDao() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	//전공 이름 리스트
	public Vector<String> mnameList(){
		Vector<String> mnames = new Vector<String>();
		mnames.add("");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MNAME FROM MAJOR";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				mnames.add(rs.getString("mname"));
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
		return mnames;
	}
	// 학번검색
	public StudentDto selectSno(int sno){
		StudentDto student = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE" + 
				"    FROM STUDENT S, MAJOR M" + 
				"    WHERE S.MNO=M.MNO AND SNO = "+ sno;
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String sname = rs.getString("sname");
				String mname = rs.getString("mname");
				int score = rs.getInt("score");
				student = new StudentDto(sno, sname, mname, score);
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
		return student;
	}
	//이름검색
	public ArrayList<StudentDto> selectSname(String sname){
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT SNO, SNAME, MNAME, SCORE" + 
				"    FROM STUDENT S, MAJOR M" + 
				"    WHERE S.MNO=M.MNO AND SNAME ='"+sname+"'";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setSno(rs.getInt("sno"));
				dto.setSname(sname);
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
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
	//학과검색
	public ArrayList<StudentDto> selectMname(String mname){
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, A.*" + 
				"    FROM (SELECT SNO, SNAME, MNAME, SCORE, M.MNO" + 
				"                FROM STUDENT S, MAJOR M" + 
				"                WHERE S.MNO=M.MNO AND MNAME = '" + mname +"'"+ 
				"                ORDER BY SCORE DESC) A";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setRank(rs.getInt("rank"));
				dto.setSno(rs.getInt("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(mname);
				dto.setMno(rs.getInt("mno"));
				dto.setScore(rs.getInt("score"));
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
	//학생입력
	public int insertStudent(StudentDto dto) {
		int result = FAIL;
		Connection 			conn = null;
		PreparedStatement 	pstmt = null;
		String sql = "INSERT INTO STUDENT(SNO, SNAME, MNO, SCORE)" + 
				"    VALUES(EXTRACT(YEAR FROM SYSDATE)||TRIM(TO_CHAR(STUDENT_SNO_SEQ.NEXTVAL, '000'))," + 
				"                ?, (SELECT MNO FROM MAJOR WHERE MNAME = ?), ?)";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
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
	// 학생 수정
	public int updateStudent(StudentDto dto) {
		int result = FAIL;
		Connection 			conn = null;
		PreparedStatement 	pstmt = null;
		String sql = "UPDATE STUDENT" + 
				"    	SET   SNAME = ?," + 
				"            MNO = (SELECT MNO FROM MAJOR WHERE MNAME = ?)," + 
				"            SCORE = ?," + 
				"            REG = 0" + 
				"    WHERE SNO = ?";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSname());
			pstmt.setString(2, dto.getMname());
			pstmt.setInt(3, dto.getScore());
			pstmt.setInt(4, dto.getSno());
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
	//학생출력
	public ArrayList<StudentDto> selectAll(){
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, S.*" + 
				"    FROM (SELECT SNO, SNAME, MNAME, SCORE, S.MNO FROM STUDENT S, MAJOR M" + 
				"                WHERE S.MNO=M.MNO AND REG = 0 ORDER BY SCORE DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setRank(rs.getInt("rank"));
				dto.setSno(rs.getInt("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
				dto.setMno(rs.getInt("mno"));
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
	//재적자 출력
	public ArrayList<StudentDto> selectReg(){
		ArrayList<StudentDto> dtos = new ArrayList<StudentDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM RANK, S.*" + 
				"    FROM (SELECT SNO, SNAME, MNAME, SCORE, S.MNO FROM STUDENT S, MAJOR M" + 
				"                WHERE S.MNO=M.MNO AND REG = 1 ORDER BY SCORE DESC) S";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				StudentDto dto = new StudentDto();
				dto.setRank(rs.getInt("rank"));
				dto.setSno(rs.getInt("sno"));
				dto.setSname(rs.getString("sname"));
				dto.setMname(rs.getString("mname"));
				dto.setScore(rs.getInt("score"));
				dto.setMno(rs.getInt("mno"));
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
	//재적처리
	public int updateReg(StudentDto dto) {
		int result = FAIL;
		Connection 	conn = null;
		Statement 	stmt = null;
		String sql = "UPDATE STUDENT" + 
				"    SET REG = 1" + 
				"    WHERE SNO =" + dto.getSno();
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {}
		}
		return result;
	}
}
