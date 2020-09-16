package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*문제)
	
		호텔 운영을 관리하는 프로그램 작성.(Map이용)
		 - 키값은 방번호 
		 
		실행 예시)
	
 **************************
		호텔 문을 열었습니다.
 **************************
	
 *******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
 *******************************************
		메뉴선택 => 1 <-- 입력
	
		어느방에 체크인 하시겠습니까?
		방번호 입력 => 101 <-- 입력
	
		누구를 체크인 하시겠습니까?
		이름 입력 => 홍길동 <-- 입력
		체크인 되었습니다.
	
 *******************************************
		어떤 업무를 하시겠습니까?
	
 *******************************************
		메뉴선택 => 1 <-- 입력
	
		어느방에 체크인 하시겠습니까?
		방번호 입력 => 102 <-- 입력
	
		누구를 체크인 하시겠습니까?
		이름 입력 => 성춘향 <-- 입력
		체크인 되었습니다
	
 *******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
 *******************************************
		메뉴선택 => 3 <-- 입력
	
		방번호 : 102, 투숙객 : 성춘향
		방번호 : 101, 투숙객 : 홍길동
	
 *******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
 *******************************************
		메뉴선택 => 2 <-- 입력
	
		어느방을 체크아웃 하시겠습니까?
		방번호 입력 => 101 <-- 입력
		체크아웃 되었습니다.
	
 *******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
 *******************************************
		메뉴선택 => 1 <-- 입력
	
		어느방에 체크인 하시겠습니까?
		방번호 입력 => 102 <-- 입력
	
		누구를 체크인 하시겠습니까?
		이름 입력 => 허준 <-- 입력
		102방에는 이미 사람이 있습니다.
	
 *******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
 *******************************************
		메뉴선택 => 2 <-- 입력
	
		어느방을 체크아웃 하시겠습니까?
		방번호 입력 => 101 <-- 입력
		101방에는 체크인한 사람이 없습니다.
	
 *******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
 *******************************************
		메뉴선택 => 3 <-- 입력
	
		방번호 : 102, 투숙객 : 성춘향
	
 *******************************************
		어떤 업무를 하시겠습니까?
		1.체크인  2.체크아웃 3.객실상태 4.업무종료
 *******************************************
		메뉴선택 => 4 <-- 입력
	
 **************************
		호텔 문을 닫았습니다.
 **************************
 */
public class T13_HotelReservationTest {
	private Scanner scan = new Scanner(System.in);
	// Map 생성
	private Map<Integer, Room> hotelMap = new HashMap<Integer, Room>();

	// 메인
	public static void main(String[] args) {
		// map의 객체 생성
		new T13_HotelReservationTest().hotelReserv();

	}

	// 메뉴
	private void hotelReserv() {
		 System.out.println("*************************");
		 System.out.println(" 호텔 문을 열었습니다.");
		 System.out.println("*************************");
		 System.out.println();
		while (true) {
			System.out.println("***********************************");
			System.out.println("\t어떤 업무를 하시겠습니까?");
			System.out.println();
			System.out.print("1.체크인  ");
			System.out.print("2.체크아웃  ");
			System.out.print("3.객실상태  ");
			System.out.println("4.업무종료");
			System.out.println("***********************************");
			System.out.println("메뉴 선택 >> ");

			int input = 0;
			try {
				input = scan.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("올바른 값을 입력해주세요!");
			}

			switch (input) {
			case 1:
				// 체크인 메서드
				checkIn();
				break;
			case 2:
				// 체크 아웃 메서드
				checkOut();
				break;
			case 3:
				// 객실 상태 조회 메서드
				roomList();
				break;
			case 4:
				// 업무 종료
				System.out.println("*************************");
				System.out.println("         호텔 문을 닫았습니다.");
				System.out.println("*************************");
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * 객실을 체크인 하는 메서드(create)
	 * 
	 * @method checkIn
	 * @return void
	 * @author 강문정
	 */
	private void checkIn() {
		System.out.println("* 어느 방에 체크인 하시겠습니까?");
		System.out.println("* 체크인을 원하시는 방 번호를 입력해주세요 >> ");
		int room = scan.nextInt();

		// 이미 등록된 방인지 검사
		if (hotelMap.get(room) != null) {
			System.out.println("해당 방에는 이미 사람이 있습니다.");
			return;
		}

		System.out.println("* 이름을 입력해주세요 >> ");
		String name = scan.next();

		// hotelMap에 room을 키값으로 하여서 저장
		hotelMap.put(room, new Room(room, name));
		System.out.println("***체크인 되었습니다.***");

	}

	/**
	 * 객실을 체크아웃 하는 메서드(삭제)
	 * 
	 * @method checkOut
	 * @return void
	 * @author 강문정
	 */
	private void checkOut() {
		System.out.println("* 어느 방에 체크 아웃 하시겠습니까?");
		System.out.println("* 체크 아웃을 원하시는 방 번호를 입력해주세요 >> ");
		int room = scan.nextInt();

		// 체크 아웃할 방번호가 있는지 검사
		if (hotelMap.get(room) == null) {
			System.out.println("***"+room + " 번 에는 체크인 한 사람이 없습니다.***");
		} else {
			 hotelMap.remove(room);
			 System.out.println("***"+room + "번은 체크아웃 되었습니다.***");
		}
	}

	/**
	 * 객실을 조회하는 메서드(조회)
	 * 
	 * @method roomList
	 * @return void
	 * @author 강문정
	 */
	private void roomList() {
		// keySet으로 현재 Map의 key값으로 이뤄진 Set객체를 가져온다.
		// key값으로 불러와 자료를 출력한다.
		System.out.println("==================================");
		System.out.println("방 번호\t이름");
		System.out.println("==================================");
		Set<Integer> keySet = hotelMap.keySet();

		// 만약 keySet의 사이즈가 0이면 안에 아무 자료도 없다는 뜻이므로 조회되지 않는다.
		if (keySet.size() == 0) {
			System.out.println("체크 인 된 객실이 없습니다..");
		} else {
			// Set에 있는 값을 조회하기 위해서 iterator
			Iterator<Integer> it = keySet.iterator();
			int cnt = 0;
			while (it.hasNext()) {
				cnt++;
				// room 번호 값을 iterator에 넣어준다.??
				int room = it.next();
				Room r = hotelMap.get(room);

				System.out.println(cnt + r.getRoom() + "\t" + r.getName());

			}
		}
		System.out.println("==================================");
		System.out.println();
	}

}

/**
 * 방의 정보를 저장하기 위한 클래스
 * 
 * @author 강문정
 */
class Room {
	int room; // 방번호
	String name; // 이름

	public Room(int room, String name) {
		super();
		this.room = room;
		this.name = name;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Room [room=" + room + ", name=" + name + "]";
	}
	
}
