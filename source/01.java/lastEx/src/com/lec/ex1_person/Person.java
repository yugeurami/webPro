package com.lec.ex1_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Person {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean ck = true;
		do {
			System.out.println("어떤 서비스를 이용하시겠습니까?");
			System.out.println("1번은 데이터 입력");
			System.out.println("2번은 직업별 등수 조회");
			System.out.println("3번은 모든 사람의 등수 조회");
			System.out.println("그 외의 문자를 입력하시면 종료합니다");
			String check = sc.next();
			switch (check) {
			case "1":
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					String sql = "INSERT INTO PERSON VALUES (PERSON_NO_SQ.NEXTVAL, ?, (SELECT JNO FROM JOB WHERE JNAME=?), ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					System.out.print("테이터 입력을 시작합니다\n이름을 입력해주세요 : ");
					String pname = sc.next().trim();
					System.out.print("직업을 입력해주세요 : ");
					String jname = sc.next().trim();
					System.out.print("국어 점수를 입력해주세요 : ");
					int kor = sc.nextInt();
					System.out.print("영어 점수를 입력해주세요 : ");
					int eng = sc.nextInt();
					System.out.print("수학 점수를 입력해주세요 : ");
					int mat = sc.nextInt();
					pstmt.setString(1, pname);
					pstmt.setString(2, jname);
					pstmt.setInt(3, kor);
					pstmt.setInt(4, eng);
					pstmt.setInt(5, mat);
					int result = pstmt.executeUpdate();
					System.out.println(result>0 ? "입력성공" : "입력실패");
					break;
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
				} catch (SQLException e) {}
			}
			case "2":
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					String sql = "SELECT ROWNUM, PNAME||'('||PNO||'번)' NAME, JNAME, KOR, ENG, MAT, SUM" + 
						"    FROM (SELECT P.*, JNAME, (KOR+ENG+MAT) SUM" + 
						"                FROM PERSON P, JOB J " + 
						"                WHERE P.JNO=J.JNO AND JNAME= ? " + 
						"                ORDER BY SUM DESC)";
					pstmt = conn.prepareStatement(sql);
					System.out.print("직업명을 입력해주세요 : ");
					String jname = sc.next().trim();
					pstmt.setString(1, jname);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						System.out.println("등수\t이름(pNo)\t\t직업\t국어(kor)\t영어(eng)\t수학(mat)\t총점");
						for(int i = 0; i<70 ; i++) {
							System.out.print('-');
						}
						System.out.println();
						do {
							int rank = rs.getInt("rownum");
							String name = rs.getString("name");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							if(name.length()<7) {
								System.out.printf("%d등\t%s\t\t%s\t%d\t%d\t%d\t%d\n",
										rank, name, jname, kor, eng, mat, sum);
							}else {
								System.out.printf("%d등\t%s\t%s\t%d\t%d\t%d\t%d\n",
										rank, name, jname, kor, eng, mat, sum);
							}
						}while(rs.next());
					} else {
						System.out.println(jname+" 직업의 사람이 존재하지 않습니다");
					}
					break;
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
				} catch (SQLException e) {}
			}
				
			case "3":
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "scott", "tiger");
					String sql = "SELECT ROWNUM, PNAME||'('||PNO||'번)' NAME, JNAME, KOR, ENG, MAT, SUM" + 
						"    FROM (SELECT P.*, JNAME, (KOR+ENG+MAT) SUM " + 
						"                FROM PERSON P, JOB J " + 
						"                WHERE P.JNO=J.JNO ORDER BY SUM DESC)";
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery(sql);
					if(rs.next()) {
						System.out.println("등수\t이름(pNo)\t\t직업\t국어(kor)\t영어(eng)\t수학(mat)\t총점");
						for(int i = 0; i<80 ; i++) {
							System.out.print('-');
						}
						System.out.println();
						do {
							int rank = rs.getInt("rownum");
							String name = rs.getString("name");
							String jname = rs.getString("jname");
							int kor = rs.getInt("kor");
							int eng = rs.getInt("eng");
							int mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							if(name.length()<7) {
								System.out.printf("%d등\t%s\t\t%s\t%d\t%d\t%d\t%d\n",
										rank, name, jname, kor, eng, mat, sum);
							}else {
								System.out.printf("%d등\t%s\t%s\t%d\t%d\t%d\t%d\n",
										rank, name, jname, kor, eng, mat, sum);
							}
						}while(rs.next());
					} else {
						System.out.println("데이터가 존재하지 않습니다");
					}
					break;
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
						if(conn!=null) conn.close();
				} catch (SQLException e) {}
			}
				
			default :
				ck = false;
				System.out.println("종료합니다");
				continue;
			}
		} while(ck);
		
		sc.close();
	}

}
