package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * WildCard도 타입 제한을 둘 수 있다. <? extends T> 와일드 카드의 상한 제한 T와 그 자손들만 가능 <? super T>
 * 와일드 카드의 하한 제한 T와 그 조상들만 가능 <?> 모든 타입 가능 <? extends Object>와 같음
 */
public class T05_WildCardTest {
	public static void main(String[] args) {
		FruitBox<Fruit> fruitBox = new FruitBox();
		FruitBox<Apple> appleBox = new FruitBox();

		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());
		appleBox.add(new Apple());

		Juice.makeJuice(fruitBox);

	}
}

/**
 * 주스를 만들기 위한 클래스
 */
class Juice {
	static void makeJuice(FruitBox<Fruit> box) {
		// 다른 방법
		// 1. 제너릭 메서드 이용 
		// static <T> void makeJuice(FruitBox<T> box){
		// 2 .제한된 타입 파라미터 문법
		// static <T extends Fruit> void makeJuice(FruitBox<Fruit> box) {
		// 3. 와일드 카드 사용
		// static void makeJuice(FruitBox<? extends Fruit> box) {
		String fruitStr = ""; // 과일목록
		int count = 0;

		for (Fruit f : box.getFruitList()) {

			if (count == 0) {
				fruitStr += f;

			} else {
				fruitStr += "," + f;
			}
			count++;

		}
		System.out.println(fruitStr + " -> 주스 완성");
	}
}

/**
 * 과일 속성의 클래스
 */
class Fruit {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Fruit(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일 [name=" + name + "]";
	}
}

class Apple extends Fruit {
	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {
	public Grape() {
		super("포도");
	}
}

/**
 * 과일 상자를 위한 상자
 * 
 * @param <T>
 */
class FruitBox<T> {
	private List<T> fruitList;

	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}

	public void setFruitList(List<T> fruitList) {
		this.fruitList = fruitList;
	}

	public void add(T fruit) {
		fruitList.add(fruit);
	}

}