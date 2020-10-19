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

/**
 * db.properties파일의 내용으로 db정보를 설정하는 방법
 * 방법 1) Properties 객체 이용하기
 */
public class JDBCUtil2 {
	static Properties prop; // Properites 변수 선언
	
	static {
		prop = new Properties();
		
		File file = new File("res/db.properties");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			
			Class.forName(prop.getProperty("driver"));
			
		} catch (IOException ex) {
			System.out.println("파일이 없어가 입출력 오류입니다.");
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
			
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
