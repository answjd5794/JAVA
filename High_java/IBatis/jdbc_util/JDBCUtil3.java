package jdbcutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * db.properties파일의 내용으로 db정보를 설정하는 방법
 * 방법 1) Properties 객체 이용하기
 */
public class JDBCUtil3 {
	static ResourceBundle bundle; // Properites 변수 선언
	
	static {
		
		try {
			bundle = ResourceBundle.getBundle("db");
			
			Class.forName(bundle.getString("driver"));
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(bundle.getString("url"),
											   bundle.getString("user"),
											   bundle.getString("pass"));
			
		} catch (SQLException e) {
			System.out.println(" DB 연결 실패 ");
			return null;
		}

	}
	
	public static void disconnect(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet rs) {
		  if(rs != null) try {rs.close();} catch(SQLException e){};
		  if(stmt != null) try {stmt.close();} catch(SQLException e){};
		  if(pstmt != null) try {pstmt.close();} catch(SQLException e){};
		  if(conn != null) try {conn.close();} catch(SQLException e){};
	}
}
