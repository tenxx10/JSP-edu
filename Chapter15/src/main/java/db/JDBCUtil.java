package db;

import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCUtil {
	
	public static Connection getConnection() {
		
		Connection con =null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLDB");
			con = ds.getConnection();
			con.setAutoCommit(false); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
		/*
		 * Connection con = null;
		 * 
		 * try { Class.forName("com.mysql.jdbc.Driver"); // JDBC 드라이버 클래스 로드 String url
		 * = "jdbc:mysql://localhost:3306/testDB"; // 데이터베이스 URL String username =
		 * "java"; // 데이터베이스 사용자 이름 String password = "java"; // 데이터베이스 비밀번호
		 * 
		 * con = DriverManager.getConnection(url, username, password); // 연결 설정
		 * 
		 * con.setAutoCommit(false); // 자동 커밋 비활성화
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * return con;
		 */
		
		
	}
	
	public static void close(Connection con) {
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		
		try {
			con.commit();
			System.out.println("commit success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		
		try {
			con.rollback();
			System.out.println("rollback success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
