package kr.or.ddit.basic;

public class T07_WildCartTest {

}

// 일반인
class Person {
	String name; // 이름

	public Person(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}

class Worker extends Person {

	public Worker(String name) {
		super(name);
	}
}

class Student extends Person {

	public Student(String name) {
		super(name);
	}
}

class HighSchool extends Student {

	public HighSchool(String name) {
		super(name);
	}
}

/**
 * 제너릭 클래스
 * 
 * @param <T>
 */
class Course<T> {
	private String name; // 코스명
	private T[] students; // 수강생

	public Course(String name, int capacity) {
		this.name = name;

		// 타입 파라미터로 배열을 생성시 오브젝트 배열을 생성 후, 타입 파라미터 배열로 캐스팅 해야함.
		students = (T[])(new Object[capacity]);
	}
	
	
	// 수강생 조회
	public String getName() {
		return name;
	}
	// 코스명 조회
	public T[] getStudents() {
		return students;
	}
	
	// 수강생 등록
	public void add(T t) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) { // 아직 등록되지 않은 빈 자리가 있는 경우
				students[i] = t;
				break;
			}
		}
	}
}