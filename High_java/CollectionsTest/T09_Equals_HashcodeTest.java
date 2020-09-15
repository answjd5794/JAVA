package kr.or.ddit.basic;

public class T09_Equals_HashcodeTest {
/**
 * 	해시 함수(hash function)은 임의의 길이의 데이터를 고정된 길이의 데이터로 매핑해주는 함수이다.
 *  해시 함수에 의해 얻어지는 값은 해시값, 해시코드, 해시체크섬 또는 간단하게 해시라고 한다.
 *  
 *  HashSet, HashMap, HashTable과 같은 객체들을 사용할 경우
 *  객체가 서로 같은지를 비교하기 위해 equals() 메서드와 hashCode() 메서드를 호출한다.
 *  그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 하여야 한다.
 *  HashSet, HashMap, HashTable에서는 객체가 같은지 여부를 데이터를 추가할 때 검사한다.
 *  
 *  - equals() 메서드는 두 객체의 내용(값)이 같은지 비교하는 메서드이고,
 *  - hashCode() 메서드는 두 객체가 같은 객체인지를 비교하는 메서드이다.
 *  
 *  - equals()메서드와 hashCode()메서드에 관한 규칙
 *  1. 두 객체가 같으면 반드시 같은 hashCode를 가져야 한다.
 *  2. 두 객체가 equals() 메서드를 호출했을 때, true를 반환하여야 한다.
 *  	즉, 객체 a와 객체 b가 같다면 a.equals(b)와 b.equals(a)는 둘 다 true이다.
 *  3. 두 객체의 hashCode가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
 *  	하지만, 두 객체가 같으면 반드시 hashCode가 같아야 한다.
 *  4. equals()메서드를 override하면 반드시 hashCode()메서드도 override 해야 한다.
 *  5. hashCode()는 기본적으로 Heap에 있는 각 객체에 대한 메모리 주소 매핑 정보를 기반으로 한 정수 값을 반환한다.
 *  	그러므로, 클래스에서 hashCode() 메서드를 override하지 않으면 절대로 두 객체가 같은 것으로 간주 될 수 없다.
 *    - hashCode() 메서드에서 사용하는 '핵심 알고리즘'에서 서로 다른 객체에 대하여 같은 hashCode()를 만들어 낼 수 있다.
 *    	그래서 객체가 같지 않더라도 hashCode가 같을 수 있다.	
 *    
 */
}

class Person {
	private int id;
	private int name;
	
	public Person(int id, int name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// prime : 소수
		result = prime * result + id;
		result = prime * result + name;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name != other.name)
			return false;
		return true;
	}
	
	
	
}