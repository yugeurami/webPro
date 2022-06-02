package com.lec.member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDaoConnPool {
	public static final int SUCCESS = 1; // 회원가입, 정보 수정 성공시 리턴값
	public static final int FAIL = 0; // 회원가입, 정보 수정 실패시 리턴값
	public static final int MEMBER_EXISTENT = 0; // 중복된 ID일 때 리턴값
	public static final int MEMBER_NONEXISTENT = 1; // 사용가능한 ID일 때 리턴값
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공시 리턴값
	public static final int LOGIN_FAIL_ID = -1; // 로그인  아이디 오류일 때 리턴값
	public static final int LOGIN_FAIL_PW = 0; // 로그인 비밀번호 오류일 때 리턴값
	
	//conn 객체 리턴하는 함수
	private Connection getConnection() throws SQLException {
		// 커넥션풀의 DataSource안의 conn 객체 이용
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println("커넥션풀 이름 오류 : " + e.getMessage());
		}
		return conn;
	}
	
	// 1. 회원가입시 id 중복 체크를 위한 SQL
	public int confirmId(String id){
		int result = MEMBER_NONEXISTENT; // 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = MEMBER_EXISTENT; // 있는 ID
			} else {
				result = MEMBER_NONEXISTENT; // 없는 ID(사용가능한 ID)				
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(rs	!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//2. 회원가입 : 
	public int joinMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, RDATE, ADDRESS)" + 
					"    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,SYSDATE, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());
			pstmt.setString(8, dto.getEmail());
			pstmt.setTimestamp(9, dto.getBirth());
			pstmt.setNString(10, dto.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원가입성공":"회원가입실패");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원가입 실패 : "+ dto);
		}finally {
			try{
				if(pstmt!=null) pstmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//3. 로그인(id/pw)
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_PW;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, pw FROM MEMBER WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) { // 유효한 ID 입력
				String pwDB = rs.getString("pw");
				if(pwDB.equals(pw)) {
					result = LOGIN_SUCCESS;
				}else {
					result = LOGIN_FAIL_PW;
				}
			} else { // 유효하지 않은 아이디
				result = LOGIN_FAIL_ID;
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(rs	!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//4. ID로 dto 가져오기
	public MemberDto getMember(String id) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String 		pw 		= rs.getString("pw");
				String 		name 	= rs.getString("name");
				String 		phone1 	= rs.getString("phone1");
				String 		phone2	= rs.getString("phone2");
				String 		phone3 	= rs.getString("phone3");
				String 		gender 	= rs.getString("gender");
				String 		email 	= rs.getString("email");
				Timestamp 	birth 	= rs.getTimestamp("birth");
				Date 		rdate 	= rs.getDate("rdate");
				String 		address = rs.getString("address");
				dto = new MemberDto(id, pw, name, phone1, phone2, phone3, gender, email, birth, rdate, address);
			} 
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(rs	!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return dto;
	}
	//5. 회원정보 수정
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET PW=?," + 
				"                       NAME = ?," + 
				"                       PHONE1 = ?," + 
				"                       PHONE2 = ?," + 
				"                       PHONE3 = ?," + 
				"                       GENDER = ?," + 
				"                       EMAIL = ?," + 
				"                       BIRTH = ?," + 
				"                       ADDRESS = ?" + 
				"                       WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone1());
			pstmt.setString(4, dto.getPhone2());
			pstmt.setString(5, dto.getPhone3());
			pstmt.setString(6, dto.getGender());
			pstmt.setString(7, dto.getEmail());
			pstmt.setTimestamp(8, dto.getBirth());
			pstmt.setNString(9, dto.getAddress());
			pstmt.setString(10, dto.getId());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원정보 수정 성공":"회원정보 수정 실패");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("회원정보 수정 실패 : "+ dto);
		}finally {
			try{
				if(pstmt!=null) pstmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}

}
