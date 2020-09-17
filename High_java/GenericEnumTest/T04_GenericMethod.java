package kr.or.ddit.basic;

class Util2 {
	// T(type) 이 Number를 상속한 타입을 적을 수 있다는 뜻 => Number로 쓸수 있다
	public static <T extends Number> int compare(T t1, T t2) {
		double v1 = t1.doubleValue();
		double v2 = t1.doubleValue();

		return Double.compare(v1, v2);
	}
}

/**
 * 제한된 타입 파라미터(Bounded Type Parameter) 예제
 */
public class T04_GenericMethod {
	public static void main(String[] args) {
		// 제한된 파라미터를 이용해서 Number타입이기 때문에 int/float 모두 사용이 가능하
		int result1 = Util2.compare(10, 20);
		System.out.println(result1);

		int result2 = Util2.compare(3.14, 3);
		System.out.println(result2);

		// Number타입에는 String이 없기 때문에 에러가 난다.
		// Util2.compare("C", "JAVA");
	}
}
