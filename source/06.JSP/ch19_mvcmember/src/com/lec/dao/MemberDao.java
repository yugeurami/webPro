package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.MemberDto;

public class MemberDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	public static final int MEMBER_EXISTENT = 0;
	public static final int MEMBER_NONEXISTENT = 1;
	
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
		int result = MEMBER_NONEXISTENT; // 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				result = MEMBER_NONEXISTENT; 			
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
	
	// 로그인
	public int login(String mid, String mpw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ? AND MPW= ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = SUCCESS;
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
		
	//회원정보 수정
	public int modify(MemberDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MVC_MEMBER " + 
				"    	SET   MPW = ?, " + 
				"            MNAME = ?," + 
				"            MEMAIL = ?," + 
				"            MPHOTO = ?," + 
				"            MBIRTH = ?," + 
				"            MADDRESS = ?" + 
				"    WHERE MID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getMpw());
			pstmt.setString(2, dto.getMname());
			pstmt.setString(3, dto.getMemail());
			pstmt.setString(4, dto.getMphoto());
			pstmt.setDate(5, dto.getMbirth());
			pstmt.setString(6, dto.getMaddress());
			pstmt.setString(7, dto.getMid());
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "회원정보 수정 성공":"회원정보 수정 실패");
		} catch(Exception e) {
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
	
	//회원리스트 출력
	public ArrayList<MemberDto> memberList(int startRow, int endRow){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *" + 
				"    FROM (SELECT ROWNUM RN, A.*" + 
				"                FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A)" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mphoto = rs.getString("mphoto");
				Date mbirth = rs.getDate("mbirth");
				String maddress = rs.getString("maddress");
				Date mrdate = rs.getDate("mrdate");
				dtos.add(new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, mrdate));
			}
		} catch (SQLException e) {
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
		return dtos;
	}
	
	//전체 회원 수 출력
	public int memberCnt() {
		int memberCnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MVC_MEMBER";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			memberCnt = rs.getInt("cnt");
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
		return memberCnt;
	}
}
