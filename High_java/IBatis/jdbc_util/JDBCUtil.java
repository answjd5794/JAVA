package jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC 드라이버를 로딩하고 Connection 객체를 생성하는 메서드 제공
 */
public class JDBCUtil {
	// static 블럭은 초기화 블럭으로 클래스가 로딩되는 시점에 자동적으로 실행해준다.
	// => 초기화 하는 statement가 많이 들어간다.
	static {
		// 드라이버 로딩하는 블럭 생성
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println(" 드라이버 로딩 완료 >> ");
		} catch (ClassNotFoundException e) {
			System.out.println(" 드라이버 로딩 실패 ");
		}
	}

	public static Connection getConnection() {

		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "moon", "java");
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
