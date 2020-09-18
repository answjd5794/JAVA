package kr.or.ddit.basic;

/**
 * 1. 리플렉션은 클래스, 또는 멤버변수, 메서드, 생성자에 대한 정보를 가져오거나 수정할 수 있다.
 * 2. Reflection API 는 java.lang.reflection 패키지와 java.lang.Class를 통해서 제공한다.
 * 3. java.lang.Class의 주요 메서드
 * 	- getName(), getSuperClass(), getInterface(), getModifiers()
 * 4. java.lang.reflect 패키지의 주요 클래스
 * 	- Field, Method, Constructor, Modifier  등등...
 *
 */

// Class 오브젝트(클래스의 정보를 담고있는)을 생성하기
public class T03_ClassObjectCreateTest {
	public static void main(String[] args) throws ClassNotFoundException {
		// 방법 1: Class.forName() 메서드 이용
		Class<?> klass = Class.forName("kr.or.ddit.reflection.T03_ClassObjectCreateTest");
		
		// 방법 2	: getClass() 메서드 이용
		T03_ClassObjectCreateTest obj = new T03_ClassObjectCreateTest();
		klass = obj.getClass();
		
		// 방법 3 : class 이용
		klass = T03_ClassObjectCreateTest.class;
	}
}
