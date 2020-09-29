package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC를 이용한 데이터베이스 처리 순서
 * 
 * 1) JDBC 드라이버 로드 => JDBC 드라이버는 DB를 만든 회사에서 제공한다.
 * Class.forName("oracle.jdbc.driver.OracleDriver"); 2) 해당 DB에 접속 => 접속에 성공하면
 * Connection 객체가 생성된다. DriverManger.getConnection() 메서드를 이용한다. 3) 질의(SQL 명령을
 * 수행한다.) => Statement 객체 또는 PreparedStatement 객체를 이용하여 SQL 문장을 실행한다. 4) 질의 결과를
 * 받아서 처리 (1) SQL문이 select일 경우 -> ResultSet 객체가 만들어진다. 이 객체는 select한 결과가 저장된다.
 * (2) SQL문이 insert, update, delete일 경우, 정수 값을 반환한다.(정수 값은 보통 실행에 성공한 레코드 수를
 * 의미한다.) 5) 종료(자원 반납)
 * 
 * 
 */
public class T01_JDBCTest {
	public static void main(String[] args) {
		// DB 작업에 필요한 객체 변수를 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // 쿼리문 select인 경우에 사용한다.

		try {
			// 1. 드라이버 로딩(옵션)
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Class.forname을 통해 오라클 jdbc 드라이버에 로딩한다.
																// 여기까지 하고 콘솔에 찍었을 때 오류가 발생하면 ""안의 문장이 오류있는 것.(로딩실패)

			// 2. DB 접속(Connection 객체 생성)
			// 필요한 정보를 파라미터 안에 넣어줘야 한다.
			String url = "jdbc:oracle:thin:@localhost:1521/xe"; // url 정보
			String userId = "moon";
			String password = "java";
			conn = DriverManager.getConnection(url, userId, password); // 커넥션 객체(url, userId, password) 가져오기

			// 3. Statement 객체 생성 => Connection 객체를 이용한다.
			stmt = conn.createStatement();

			// 4. SQL문을 Statement객체를 이용하여 실행하고 실행 결과를 ResultSet에 저장한다.
			String sql = "select * from lprod"; // sql문 실행
			rs = stmt.executeQuery(sql); // ResultSet에 저장
			
			/**
			 * SQL 문이 select 일 경우에는 executeQuery() 메서드를 호출하고 insert/update/delete 일 경우에는
			 * executeUpdate() 메서드를 호출한다.
			 */

			// 5. ResultSet 객체가 저장되어 있는 자료를 반복문과 next() 메서드를 이용하여 차례대로 읽어와서 처리한다.
			System.out.println("실행한 쿼리문 : " + sql);
			System.out.println("=========== 쿼리문 실행 결과 ===========");

			// rs.next() => ResultSet 객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고 그 곳에 자료가 있으면 true,
			// 없으면 false를 반환한다.
			while (rs.next()) {
				// 컬럼의 자료를 가져오는 방법 
				// 1. rs.get 자료형이름 ("컬럼명");
				System.out.println("lprod_id : " + rs.getInt("lprod_id")); 
				System.out.println("lprod_gu : " + rs.getString("lprod_gu"));
				System.out.println("lprod_nm : " + rs.getString("lprod_nm"));
				System.out.println("----------------------------------");
				// 2. rs.get 자료형이름 ("컬럼 번호") => 컬럼 번호는 1부터 시작
				// System.out.println("lprod_id : " + rs.getInt(1)); 
				
			}
			System.out.println("============ 출  력  끝 =============");


		} catch (SQLException e) {
			e.printStackTrace();
			// Class.forName 의 오류 => ClassNotFoundException
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
		         //6. 종료(자원 반납)
		  if(rs != null) try {rs.close();} catch(SQLException e){};
		  if(stmt != null) try {stmt.close();} catch(SQLException e){};
		  if(conn != null) try {conn.close();} catch(SQLException e){};
		}
	}
}