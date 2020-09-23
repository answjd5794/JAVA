package kr.or.ddit.basic;

/**
 * 함수적 인터페이스 => 추상 메서드가 1개만 선언된 인터페이스 
 *
 */
@FunctionalInterface // => 함수적 인터페이스
public interface LamdaTestInterface1 {
	// 추상 메서드 정의, 반환값이 없고 매개변수도 없는 추상메서드 선언
	public void test();

}

interface LamdaTestInterface2 {
	// 반환값이 없고 매개변수는 있는 추상메서드 선언
	public void test(int a);

}

interface LamdaTestInterface3 {
	// 반환값이 있고 매개변수도 있는 추상메서드 선언
	public int test(int a, int b);

}
