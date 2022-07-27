package com.test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.test.dto.MemberDto;
import com.test.dto.MoneyDto;

public class MoneyDao {
	public static final int SUCCESS = 1; 
	public static final int FAIL = 0;
	
	private static MoneyDao instance = new MoneyDao();
	public static MoneyDao getInstance() {
		return instance;
	}
	public MoneyDao() {}
	
	private Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	public ArrayList<MoneyDto> moneyList(){
		ArrayList<MoneyDto> dtos = new ArrayList<MoneyDto>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT PCODE, SUM(PRICE) ALLPRICE FROM MONEY" + 
				"    GROUP BY PCODE" + 
				"    ORDER BY ALLPRICE DESC";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String pcode = rs.getString("pcode");
				int allprice = rs.getInt("allprice");
				MoneyDto dto = new MoneyDto(pcode, allprice);
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
