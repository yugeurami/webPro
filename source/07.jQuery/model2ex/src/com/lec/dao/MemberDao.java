package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.MemberDto;

public class MemberDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int EXISTENT = 0;
	public static final int NONEXISTENT = 1;
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	private MemberDao() {}
	
	private Connection getConnection () throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	//id중복체크
	public int idCheck(String mid) {
		int result = NONEXISTENT; // 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = EXISTENT; 			
			}
		}catch(Exception e) {
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
	//id중복체크
	public int emailCheck(String memail) {
		int result = NONEXISTENT;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MEMAIL = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memail);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = EXISTENT; 			
			}
		}catch(Exception e) {
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
	
	// 회원가입
	public int join(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MVC_MEMBER(MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS)" + 
						"         VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getMpw());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getMemail());
			pstmt.setString(5, dto.getMphoto());
			pstmt.setDate(6, dto.getMbirth());
			pstmt.setString(7, dto.getMaddress());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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
	
	//mid로 dto 가져오기
	public MemberDto getMember(String mid) {
		MemberDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String 		mpw 		= rs.getString("mpw");
				String 		mname 	= rs.getString("mname");
				String 		memail 	= rs.getString("memail");
				String 		mphoto 	= rs.getString("mphoto");
				Date 		mbirth 	= rs.getDate("mbirth");
				String 		maddress = rs.getString("maddress");
				Date 		mrdate 	= rs.getDate("mrdate");
				dto = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate);
			} 
		}catch(Exception e) {
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
}
