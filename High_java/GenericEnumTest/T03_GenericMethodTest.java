package kr.or.ddit.basic;

/**
 * 파라미터 타입과 리턴 타입으로 타입 파라미터를 가지는 메서드 선언 방법 : 리턴 타입 앞에 <> 기호를 추가하고 타입 파라미터를 기술 후
 * 사용한다.
 */

class Util {
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());

		return keyCompare && valueCompare;

	}
}

// 멀티 타입<K, V>을 가지는 제너릭 클래스 (2개 이상도 가질 수 있다)
class Pair<K, V> {
	private K key;
	private V value;

	// 키와 값을 출력하는 메서드
	public <K, V> void display(K key, V value) {
		System.out.println(key.toString() + " : " + value);

	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;

	}
}

public class T03_GenericMethodTest {
	public static void main(String[] args) {

		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");

		// 구체적 타입을 명시적으로 지정 (생략 가능)
		boolean result1 = Util.<Integer, String>compare(p1, p2); // <Integer, String> 생략 가능

		if (result1) {
			System.out.println("논리적 의미로 동일한 객체");

		} else {
			System.out.println("논리적 의미로 동일한 객체가 아님");

		}

		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("002", "홍길동");

		boolean result2 = Util.compare(p3, p4);

		if (result2) {
			System.out.println("논리적 의미로 동일한 객체");

		} else {
			System.out.println("논리적 의미로 동일한 객체가 아님");
		}

		// 제너릭 메서드
		p1.display("키 값", 1234);
	}
}