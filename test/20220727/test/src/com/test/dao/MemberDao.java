package com.test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.dto.MemberDto;

public class MemberDao {
	public static final int SUCCESS = 1; 
	public static final int FAIL = 0;
	
	private static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	public MemberDao() {}
	
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	public ArrayList<MemberDto> memberList(){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				MemberDto dto = new MemberDto(custno, custname, phone, address, joindate, grade, city, 0);
				dtos.add(dto);
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(rs	!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
	
	public MemberDto getMember(int custno){
		MemberDto dto = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE CUSTNO = "+ custno;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				Date joindate = rs.getDate("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				dto = new MemberDto(custno, custname, phone, address, joindate, grade, city, 0);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(rs	!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return dto;
	}
	
	public int getCustno(){
		int nowno = FAIL;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MAX(CUSTNO)+1 NOWNO FROM MEMBER";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			nowno = rs.getInt("nowno");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(rs	!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return nowno;
	}
	
	public int memberJoin(String custname, String phone, String address, Date joindate, String grade, String city){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER (CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY)" + 
				"    VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, UPPER(?), ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custname);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setDate(4, joindate);
			pstmt.setString(5, grade);
			pstmt.setString(6, city);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
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
	public int memberModify(int custno, String custname, String phone, String address, Date joindate, String grade, String city){
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER" + 
				"    SET CUSTNAME = ?," + 
				"          PHONE = ?," + 
				"          ADDRESS = ?," + 
				"          JOINDATE = ?," + 
				"          GRADE = UPPER(?)," + 
				"          CITY = ?" + 
				"    WHERE CUSTNO = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custname);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setDate(4, joindate);
			pstmt.setString(5, grade);
			pstmt.setString(6, city);
			pstmt.setInt(7, custno);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
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
	
	public ArrayList<MemberDto> memberPriceList(){
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT M.CUSTNO, CUSTNAME, GRADE, ALLPRICE" + 
				"    FROM MEMBER M, (SELECT CUSTNO, SUM(PRICE) ALLPRICE FROM MONEY GROUP BY CUSTNO) B" + 
				"    WHERE M.CUSTNO=B.CUSTNO" + 
				"    ORDER BY ALLPRICE DESC";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String grade = rs.getString("grade");
				int allprice = rs.getInt("allprice");
				MemberDto dto = new MemberDto(custno, custname, null, null, null, grade, null, allprice);
				dtos.add(dto);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(rs	!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn	!=null) conn.close();
			}catch(Exception e2){
				System.out.println(e2.getMessage());
			}
		}
		return dtos;
	}
}
