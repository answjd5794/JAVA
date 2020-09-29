package kr.or.ddit.basic;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import JDBCUtil.T01_JDBCUtil;

/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128)    -- 주소
);

*/
public class T02_MemberInfoTest {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Scanner scan = new Scanner(System.in); 
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
					insertMember();
					break;
				case 2 :  // 자료 삭제
					deleteMember();
					break;
				case 3 :  // 자료 수정
					updateMember();
					break;
				case 4 :  // 전체 자료 출력
					displayMemberAll();
					break;
				case 5 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=5);
	}
	
	/**
	 * 회원 정보 삭제를 위한 메서드
	 * (입력받은 ID를 이용해서 삭제한다.)
	 * @method deleteMember
	 * @return void
	 * @author 강문정
	 */
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.println("회원 ID >> ");
		String memId = scan.next();
		
		try {
			conn = T01_JDBCUtil.getConnection();
			
			String sql = "delete from mymember "
						+ "where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			//물음표 값을 넣어줘야함
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("삭제가 완료 되었습니다.");
			} else {
				System.out.println("삭제가 실패하였습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			T01_JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 회원정보를 수정하는 메서드
	 * @method updateMember
	 * @return void
	 * @author 강문정
	 */
	private void updateMember() {
		boolean chk = false; // 기존 회원의 존재 여부를 확인하기 위해 생성 (존재하면 생성안되게 하기 위해서)
		String memId = "";

		do {
			// 1. 사용자의 입력을 scanner로 받음
			System.out.println();
			System.out.println("수정할 회원의 정보를 입력하세요.");
			System.out.println("회원 ID >>");
			memId = scan.next();
			
			chk = getMember(memId);// 체크하는 메서드 =>ID가 있는지 없는지
			
			if (!chk) {
				System.out.println("회원 ID가 :" + memId + "인 회원은 존재하지 않습니다.");
				System.out.println("다시 입력해주세요.");
			}
		} while (chk == false); // insert와 다르게 이미존재하는 데이터가 있어야지 입력을받음
	
		System.out.println("회원 이름 : " );
		String memName = scan.next();
		
		System.out.println("회원 전화번호 :");
		String memTel = scan.next();
		scan.nextLine(); // 입력 버퍼 지우기
		
		System.out.println("회원 주소 :");
		String memAddr = scan.nextLine();
		
		try {
			conn = T01_JDBCUtil.getConnection();
			
			String sql = "update mymember "
						+ "set mem_name = ? "
						+ ", mem_tel = ? "
						+ ", mem_addr = ? "
						+ "where mem_id = ? ";
						
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0) {
				System.out.println(memId + " 님의 회원 정보가 수정되었습니다.");
			} else {
				System.out.println(memId + " 님의 회원 정보 수정에 실패하였습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			T01_JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
	}

	/**
	 * 전체 회원을 출력하는 메서드
	 * 
	 * @method displayMemberAll
	 * @return void
	 * @author 강문정
	 */
	private void displayMemberAll() {
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println(" ID\t이름\t전화번호\t\t주소");
		System.out.println("----------------------------------------------");

		try {
			conn = T01_JDBCUtil.getConnection();
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				System.out.println(memId + "\t" + memName + "\t" + memTel + "\t" + memAddr);
				System.out.println("----------------------------------------------");
			}
		} catch (SQLException e) {
			System.out.println("== 가져오기 실패 ==");
			e.printStackTrace();
		} finally {
			T01_JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}

	}

	/**
	 * 회원을 추가하기 위한 메서드
	 * @method insertMember
	 * @return void
	 * @author 강문정
	 */
	private void insertMember() {
		boolean chk = false; // 기존 회원의 존재 여부를 확인하기 위해 생성 (존재하면 생성안되게 하기 위해서)
		String memId = "";

		do {
			// 1. 사용자의 입력을 scanner로 받음
			System.out.println();
			System.out.println("추가할 회원의 정보를 입력하세요.");
			System.out.println("회원 ID >>");
			memId = scan.next();
			
			chk = getMember(memId);// 체크하는 메서드 =>ID가 있는지 없는지
			
			if (chk) {
				System.out.println("회원 ID가 :" + memId + "인 회원은 이미 존재합니다.");
				System.out.println("다시 입력해주세요.");
			}
		} while (chk == true);
	
		System.out.println("회원 이름 : " );
		String memName = scan.next();
		
		System.out.println("회원 전화번호 :");
		String memTel = scan.next();
		scan.nextLine(); // 입력 버퍼 지우기
		
		System.out.println("회원 주소 :");
		String memAddr = scan.nextLine();
		
		try {
			conn = T01_JDBCUtil.getConnection();
			// preparedStatement에 맞는 와일드 카드를 이용한 쿼리
			String sql = "insert into mymember ("
						+ "mem_id, "
						+ "mem_name, "
						+ "mem_tel, "
						+ "mem_addr )"
						+ "values (?,?,?,?)";
			
			// 커넥션 객체 필요
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
			
			// return 값은 int
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0 ) { //insert 가 잘 되었다면
				System.out.println(memId + " 님 회원 추가 성공");
			} else {
				System.out.println(memId + " 님 회원 추가 실패");
				
			}
		} catch (SQLException e) { // pstmt = conn.prepareStatement(sql);를 쓰면 오류 해결
			System.out.println(memId + " 님 회원 추가 실패");
			e.printStackTrace();
		} finally {
			T01_JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
	}
	
	/**
	 * 회원 가입할 때 회원ID가 존재하는지 체크하는 메서드(중복 검사)
	 * @method getMember
	 * @param memId
	 * @return
	 * @return boolean
	 * @author 강문정
	 */
	private boolean getMember(String memId) {
		boolean chk = false;
		try {
			// Connection 객체를 가져오는 부분을 중복되기 때문에 class로 분할한다.
			conn = T01_JDBCUtil.getConnection(); // UTIL 클래스를 가져온다.
			String sql = "select count(*) cnt from mymember "
						+ "where mem_id = ? "; // (?) : WildCard => PreparedStatement를 쓰기 위해서 사용됨
											   // "where mem_id = "'" + mem_id + "'"; => 일반적인 Statement 방식
											   // Statement의 단점: sql 인젝션(악의적인 DB공격)이 발생할 수 있다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId); // 필요한 ? 은 모두 사라짐
			
			rs = pstmt.executeQuery(); // select => exevuteQuery();
			
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("cnt"); // 컬럼 이름을 cnt로 줬기 때문에 select count(*) >>cnt<< from mymember;
			}
			
			if (count>0) {
				chk = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			T01_JDBCUtil.disConnect(conn, stmt, pstmt, rs); // 필요한 자원을 반납하는 메서드
		}
		return chk;
	}


	public static void main(String[] args) {
		T02_MemberInfoTest memObj = new T02_MemberInfoTest();
		memObj.start();
	}

}






