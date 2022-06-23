package com.lec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.AdminDto;

public class AdminDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static AdminDao instance = new AdminDao();
	public static AdminDao getInstance() {
		return instance;
	}
	private AdminDao() {}
	
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
	
	// 로그인
	public int login(String aid, String apw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ADMIN WHERE AID = ? AND APW = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aid);
			pstmt.setString(2, apw);
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
	//aid로 dto 가져오기
		public AdminDto getAdmin(String aid) {
			AdminDto dto = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM ADMIN WHERE AID = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, aid);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String 		apw 		= rs.getString("apw");
					String 		aname 	= rs.getString("aname");
					dto = new AdminDto(aid, apw, aname);
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
