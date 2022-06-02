package com.lec.friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class FriendDaoConn {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static FriendDaoConn instance;
	public static FriendDaoConn getInstance() {
		if(instance==null) {
			instance = new FriendDaoConn();
		}
		return instance;
	}
	public FriendDaoConn() {}
	
	private Connection getConnection() throws Exception  {
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
	
	// 1. 친구 추가
	public int insertFriend (String name, String phone) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO FRIEND (FNUM, NAME, PHONE)" + 
					"    VALUES (FRIEND_SEQ.NEXTVAL, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, name);
			pstmt.setNString(2, phone);
			result = pstmt.executeUpdate();
			System.out.println(result==SUCCESS? "성공":"실패");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("실패");
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
	
	// 2. 출력 및 검색
	public ArrayList<FriendDto> outputFriend(String name, String phone){
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM FRIEND WHERE NAME LIKE '%'||?||'%' AND  PHONE LIKE   '%'||?||'%'";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, name);
			pstmt.setNString(2, phone);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fnum = rs.getInt("fnum");
				name = rs.getString("name");
				phone = rs.getNString("phone");
				dtos.add(new FriendDto(fnum, name, phone));
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
}
