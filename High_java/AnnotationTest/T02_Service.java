package kr.or.ddit.basic;


public class T02_Service {
	
	@T01_AnnotationTest
	public void method1() {
		System.out.println("메서드1에서 출력되어씁니다.1");
		
	}
	@T01_AnnotationTest(value = "%")
	public void method2() {
		System.out.println("메서드2에서 출력되어씁니다.1");
		
	}
	@T01_AnnotationTest(value = "#", count = 25)
	public void method3() {
		System.out.println("메서드3에서 출력되어씁니다.1");
		
	}
}
