package com.lec.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lec.dto.BookDto;

public class BookDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private static BookDao instance = new BookDao();
	public static BookDao getInstance() {
		return instance;
	}
	private BookDao() {}
	
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
	
	// 책 등록하기
	public int insertBook(BookDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOOK(BID, BTITLE, BPRICE, BIMG1, BIMG2, BCONTENT, BDISCOUNT)" + 
				"                VALUES(BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setInt(2, dto.getBprice());
			pstmt.setString(3, dto.getBimg1());
			pstmt.setString(4, dto.getBimg2());
			pstmt.setString(5, dto.getBcontent());
			pstmt.setInt(6, dto.getBdiscount());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return result;
	}
	//책 목록(전체 list)
	public ArrayList<BookDto> listBook(){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK ORDER BY BRDATE DESC";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				int bprice  = rs.getInt("bprice");
				String bimg1 = rs.getString("bimg1");
				String bimg2 = rs.getString("bimg2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				BookDto dto = new BookDto(bid, btitle, bprice, bimg1, bimg2, bcontent, bdiscount, brdate);
				books.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return books;
	}
	
	// 책 목록 (paging)
	public ArrayList<BookDto> listBook(int startRow, int endRow){
		ArrayList<BookDto> books = new ArrayList<BookDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *" + 
				"    FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY BRDATE DESC) A )" + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				int bprice  = rs.getInt("bprice");
				String bimg1 = rs.getString("bimg1");
				String bimg2 = rs.getString("bimg2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				BookDto dto = new BookDto(bid, btitle, bprice, bimg1, bimg2, bcontent, bdiscount, brdate);
				books.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return books;		
	}
	
	// 등록된 책 갯수
	public int bookTotCnt() {
		int bookTotalCnt = FAIL;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM BOOK";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			bookTotalCnt = rs.getInt("cnt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return bookTotalCnt;
	}
	
	// 책 상세보기(BID로 DTO 가져오기)
	public BookDto getBook(int bid) {
		BookDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BOOK WHERE BID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String btitle = rs.getString("btitle");
				int bprice  = rs.getInt("bprice");
				String bimg1 = rs.getString("bimg1");
				String bimg2 = rs.getString("bimg2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				Date brdate = rs.getDate("brdate");
				dto = new BookDto(bid, btitle, bprice, bimg1, bimg2, bcontent, bdiscount, brdate);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return dto;
	}
}
