package kr.or.ddit.basic;

/**
 * 제너릭 클래스를 만드는 방법 
 * 	형식) class 클래스명 <제너릭 타입 글자> { 
 * 		제너릭 타입 글자 변수명 ; // 변수 선언에 제너릭을 사용할 경우 		
 * 			...
 * 
 * 제너릭 타입 글자() { // 반환 값이 있는 메서드에서 사용
 * 
 * 			... return 값; 
 * 		} 	
 * 	... 
 * }
 * 
 * ...제너릭 타입 금지... 
 * 	T => type 
 * 	K => Key 
 *	V => Value 
 * 	E => Element(자료구조에 들어가는 항목들을 나타낼 때 사용)
 * 
 */

class NonGeneric {

	// 장점은 Object는 어떤 타입이든 들어갈 수 있다.
	// 단점은 계속 특정 타입으로 형변환을 해야한다.
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}

// 제너릭 문법을 이용하여 내가 사용할 타입을 정의해준다.
// T가 뭐가 될지 모르기 때문에 제너릭 타입 => 내가 타입을 정의한 순간에 하나의 타입밖에 사용하지 못한다.
// 타입이 정의되기 전까지 T로 사용이 가능하다.
class MyGeneric<T> {
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}

// 제너릭 클래스를 사용하는 방법
public class T02_GenericTest {
	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setVal("가나다라");

		NonGeneric ng2 = new NonGeneric();
		ng2.setVal(100);

		String rtnNg1 = (String) ng1.getVal();
		System.out.println("문자열 반환값 ng1 => " + rtnNg1);

		Integer irtnNg2 = (Integer) ng2.getVal();
		System.out.println("정수 반환값 ng2 => " + irtnNg2);

		MyGeneric<String> ma1 = new MyGeneric();
		MyGeneric<Integer> ma2 = new MyGeneric();

		ng1.setVal("우리나라");
		ng2.setVal(500);

		rtnNg1 = ma1.getVal();
		irtnNg2 = ma2.getVal();

		System.out.println("제너릭 문자열 반환값 : " + rtnNg1);
		System.out.println("제너릭 정수형 반환값 : " + irtnNg2);

	}
}