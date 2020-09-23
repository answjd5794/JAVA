package kr.or.ddit.basic;


/**
 * 	람다식 작성 방법
 *  기본 형식: (자료형의 이름 매개변수 명, ...) -> {실행문들;...}
 *  	1) 매개변수의 '자료형 이름'은 생략할 수있다.
 *			 예) (int a) -> {System.out.println(a); }
 *  		`	(a) -> {System.out.println(a); }
 *  	2) 매개변수가 1개일 때는 괄호()를 생략할 수 있다.
 * 		    (단, 자료형 이름을 지정할 경우에는 괄호를 생략할 수 없다.)
 * 			예) a -> {System.out.println(a);}
 * 		3) '실행문'이 1개일 경우에는 '{}'를 생략할 수 있다. (이때, 문장의 끝을 나타내는 세미콜론들도 생략한다.)
 * 			예) a-> System.out.println(a)
 * 		4) 매개 변수가 하나도 없으면 괄호 '()'를 생략할 수 없다.
 * 			예) () -> System.out.println(a)
 * 		5) 반환 값이 있을 경우에는 return 명령을 사용한다.
 * 			예) (a,b) -> { return a+b; }
 * 				(a,b) -> return a+b;
 * 		6) 실행문에 return문만 있을 경우 return의 명령과 '{}'를 생략할 수 있다.
 * 			예) (a,b) -> a+b; 
 *
 */
public class T02_LamdaTest {
	public static void main(String[] args) {

		// 람다식을 사용하지 않았을 경우
		LamdaTestInterface1 lam1 = new LamdaTestInterface1() {

			@Override
			public void test() {
				System.out.println("안녕하세요");
				System.out.println("익명 구현 개체 방식입니다.");
			}
		};
		lam1.test();
		LamdaTestInterface1 lam2 = () -> System.out.println("반가워요 람다식으로 처리하는 방식입니다.");
		System.out.println("=======================================");
		lam2.test();

		LamdaTestInterface2 lam3 = (int z) -> {
			int result = z + 100;
			System.out.println("result =" + result);
		};
		lam3.test(30);

		LamdaTestInterface2 lam4 = z -> {
			int result = z + 300;
			System.out.println("result =" + result);
		};
		lam4.test(60);

		LamdaTestInterface2 lam5 = z -> System.out.println("result = " + (z + 500));
		lam4.test(90);

		LamdaTestInterface3 lam6 = (int x, int y) -> {
			int result = x + y;
			return result;
		};
		int k = lam6.test(20, 50);
		System.out.println("k : " + k);
		
		LamdaTestInterface3 lam7 = 
				(x, y) -> {
					return x+y;
				};
		k = lam7.test(20, 50);		
		System.out.println("k : " + k);
		
		LamdaTestInterface3 lam8 =
				(x, y) -> x + y;
		k = lam8.test(60, 50);	
		System.out.println("k : " + k);
		
		LamdaTestInterface3 lam9 =
				(x, y) -> { return x > y ? x : y; };
		
		k = lam9.test(100, 50);	
		System.out.println("k : " + k);
				
	}
}
