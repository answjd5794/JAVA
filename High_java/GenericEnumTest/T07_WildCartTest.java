package kr.or.ddit.basic;

import java.util.Arrays;

public class T07_WildCartTest {

	/**
	 * 모든 과정을 등록하는 메서드
	 * 
	 * @method registerCourse
	 * @return void
	 * @author 강문정
	 */
	public static void registerCourse(Course<?> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));

	}

	/**
	 * 학생 과정 등록 메서드 (학생만 받겠다)
	 * 
	 * @method registerCourseStudent
	 * @return void
	 * @author 강문정
	 */
	public static void registerCourseStudent(Course<? extends Student> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));
	}

	/**
	 * 일반인 과정 등록 메서드
	 * 
	 * @method registerCourseWorker
	 * @param course
	 * @return void
	 * @author 강문정
	 */
	public static void registerCourseWorker(Course<? super Worker> course) {
		System.out.println(course.getName() + "수강생 : " + Arrays.toString(course.getStudents()));
	}

	public static void main(String[] args) {
		Course<Person> personCourse = new Course<>("일반인 과정", 5);
		personCourse.add(new Person("일반인 1"));
		personCourse.add(new Worker("직장인 1"));
		personCourse.add(new Student("학생 1"));
		personCourse.add(new HighSchool("학생 1"));

		Course<Worker> workerCourse = new Course<>("직장인 과정", 5);
		workerCourse.add(new Worker("직장인1"));

		Course<Student> studentCourse = new Course<>("학생 과정", 5);
		studentCourse.add(new Student("학생1"));
		studentCourse.add(new Student("고등학생1"));

		Course<HighSchool> highStudentCourse = new Course<>("고등 학생 과정", 5);
		highStudentCourse.add("고등학생1");

		registerCourse(personCourse);
		registerCourse(workerCourse);
		registerCourse(studentCourse);
		registerCourse(highStudentCourse);
		System.out.println("============================================");
		// registerCourseStudent(personCourse);
		// registerCourseStudent(workerCourse);
		registerCourseStudent(studentCourse);
		registerCourseStudent(highStudentCourse);
		System.out.println("============================================");
		registerCourseWorker(personCourse);
		registerCourseWorker(workerCourse);
		// registerCourseWorker(studentCourse);
		// registerCourseWorker(highStudentCourse);
	}
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
		students = (T[]) (new Object[capacity]);
	}

	public void add(String string) {
		// TODO Auto-generated method stub

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