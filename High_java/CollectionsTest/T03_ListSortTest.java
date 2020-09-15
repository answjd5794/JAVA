package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 2020년 9월 14일 수업
 */

public class T03_ListSortTest {

	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();

		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-2222"));
		memList.add(new Member(9, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "이순신", "010-4444-4444"));
		memList.add(new Member(6, "강감찬", "010-5555-5555"));
		memList.add(new Member(2, "일지매", "010-6666-6666"));

		System.out.println("정렬전 : ");

		for (Member mem : memList) {
			System.out.println(mem);

		}
		System.out.println();
		System.out.println("=====================================");

		Collections.sort(memList);

		System.out.println("이름 오름차순으로 정렬 후 : ");

		for (Member mem : memList) {
			System.out.println(mem);
		}

		System.out.println();
		System.out.println("=====================================");

		// 외부 정렬 기준을 이용한 정렬하기
		// 별도로 구현할 때 외부 정렬 기준 compareTo를 이용한다.
		// 예: 기본 이름 정렬 후 번호로 정렬을 다시 하려고 할 떄 등등...
		Collections.sort(memList, new SortNumDesc());

		System.out.println("번호의 내림차순으로 정렬 후 : ");
		for (Member mem : memList) {
			System.out.println(mem);

		}
	}
}

/**
 * 정렬 기준의 외부 선언을 위해서는 Comparator 인터페이스를 구현하면 된다. 
 * (Member 객체의 번호(num)의 내림차순으로 정렬하기)
 */

class SortNumDesc implements Comparator<Member> {

	@Override
	public int compare(Member m1, Member m2) {
		
		if (m1.getNum() > m2.getNum()) {
			return -1;

		} else if (m1.getNum() == m2.getNum()) {
			return 0;

		} else {
			return 1;
		}
		
		
		/**
		 * - wrapper 클래스에서 제공하는 메서드를 이용하는 방법 1
		 * 기본으로 오름차순 이기 때문에 내림차순으로 정렬하기 위해서는 * -1을 해줘야 한다.
		 * 
		 * return Integer.compare(m1.getNum(), m2.getNum()) * -1;
		 */
		
		/**
		 * - wrapper 클래스에서 제공하는 메서드를 이용하는 방법 2
		 *  기본으로 오름차순 이기 때문에 내림차순으로 정렬하기 위해서는 * -1을 해줘야 한다.
		 *  
		 * return new Integer.compare(m1.getNum()).compareTo(m2.getNum()) * -1;
		 */
		
		
	}
}

/**
 * 회원의 정보를 저장할 클래스 (회원 이름을 기준으로 오름차순 정렬이 될 수 있는 클래스 만들기)
 */

class Member implements Comparable<Member> {

	private int num; // 번호
	private String name; // 이름
	private String tel; // 전화번호

	/**
	 * 3개의 필드값을 가지고 초기화되는 생성자
	 */

	public Member(int num, String name, String tel) {

		super();
		this.num = num;
		this.name = name;
		this.tel = tel;

	}

	/**
	 * 이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	 */

	@Override

	public int compareTo(Member m) {
		return getName().compareTo(m.getName()); // member 객체가 가지고 있는 이름만 갖고 와서 비교한다.

	}

	public int getNum() {
		return num;

	}

	public void setNum(int num) {
		this.num = num;

	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;

	}

	public String getTel() {
		return tel;

	}

	public void setTel(String tel) {
		this.tel = tel;

	}

	@Override

	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";

	}

}