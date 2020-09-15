package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다. 생성자는 학번, 이름,
 * 국어, 영어, 수학 점수만 매개변수로 받는다.
 * 
 * 이 Student 객체들은 List에 저장하며 관리한다. List에 저장한 데이터들을 학번의 오름차순으로 정렬하여 출력하는 부분과 총점의
 * 역순으로 정렬하는 부분을 프로그램 하시오. (총점이 같으면 학번의 내림차순으로 정렬되도록 한다.) (학번 정렬 기준은 Student 클래스
 * 자체에서 제공하도록 하고, 총점 정렬은 외부 클래스에서 제공하도록 한다.
 */
public class T04_StudentTest {
	public static void main(String[] args) {
		List<Student> stuList = new ArrayList<Student>();

		stuList.add(new Student("6", "홍길동", 50, 50, 50));
		stuList.add(new Student("3", "강감찬", 70, 10, 80));
		stuList.add(new Student("5", "이순신", 90, 100, 70));
		stuList.add(new Student("2", "성춘향", 30, 20, 10));
		stuList.add(new Student("4", "변학도", 40, 20, 90));
		stuList.add(new Student("1", "이순신", 10, 20, 30));

		/**
		 * for(int i=0; i<stuList.size; i++){ 
		 * 		stuList.get(i); 
		 * 		for (int j = 0; j <stuList; j++) { //1등 데이터와 다음 데이터 비교 
		 * 			if(grade[i]<grade[j]){ // 만약 1등데이터가 다음데이터보다 작으면 2등으로 ++ 
		 * 			grade[i]++; } 
		 * 				} 
		 * 			}
		 */

		// 등수
		// List의 size 보다 적게 반복됨
		// stuList의 index i 번째 값을 가져옴
		for (int i = 1; i < stuList.size()+1; i++) {
			stuList.get(i-1).setGrade(i);
		}
		
		
		// 정렬 전
		System.out.println("모든 정렬 하기 전 : ");

		for (Student stu : stuList) {
			System.out.println(stu);
		}

		System.out.println();
		System.out.println("=====================================");

		// 학번으로 오름차순 정렬
		Collections.sort(stuList);

		// 학번의 오름차순으로 정렬하여 출력
		System.out.println("학번 오름차순으로 정렬 후 : ");

		for (Student stu : stuList) {
			System.out.println(stu);
		}

		System.out.println();
		System.out.println("=====================================");

		// 총점의 역순으로 정렬하여 출력
		// 총점이 같으면 내림차순으로 정렬
		Collections.sort(stuList, new totalDesc());

		System.out.println("총점으로 내림차순 정렬 후 : ");
		int grade = 1;
		for (Student stu : stuList) {
			System.out.println(stu);
			
		}
		
		System.out.println();
		System.out.println("=====================================");

	}

}

// 총점의 역순
class totalDesc implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {

		// 매개변수 s1의 총점이 s2의 총점보다 크면 내림차순
		if (s1.getTotal() > s2.getTotal()) {
			return -1;

			// 매개변수 s1의 총점이 s2의 총점과 같으면 내림차순
		} else if (s1.getTotal() == s2.getTotal()) {
			return -1;

		} else {
			return 1;
		}
	}

}

// 학번의
class Student implements Comparable<Student> {
	private String num; // 학번
	private String name; // 이름
	private int language; // 국어 점수
	private int english; // 영어 점수
	private int math; // 수학 점수
	private int total; // 총 점수
	private int grade; // 등수

	// 학번, 이름, 국어, 영어, 수학만 갖는 생성자
	public Student(String num, String name, int language, int english, int math) {
		super();
		this.num = num;
		this.name = name;
		this.language = language;
		this.english = english;
		this.math = math;
		this.total = language + english + math;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLanguage() {
		return language;
	}

	public void setLanguage(int language) {
		this.language = language;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	// 학번의 오름차순으로 정렬
	@Override
	public int compareTo(Student stu) {
		return getNum().compareTo(stu.getNum());
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", language=" + language + ", english=" + english + ", math="
				+ math + ", total=" + total + ", grade=" + grade + "]";
	}

}
