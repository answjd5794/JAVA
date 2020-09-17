package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06_WildCardTest {
	// FruitBox2<? extends Fruit> > fruitBox1 = new FruitBox2<Fruit>();
	FruitBox2<?> fruitBox1 = new FruitBox2();
	FruitBox2<?> fruitBox2 = new FruitBox2<>(); // 위와 동일한 코드

	// FruitBox2<?>는 FruitBox2<? extends Fruit>를 의미함. *오류
	// FruitBox2<?> fruitBox3 = new FruitBox2<Object>();

	// FruitBox2<Object> fruitBox4 = new FruitBox2<Fruit>();
	// 두 타입 (Object, Fruit) 이 일치하지 않는다.*오류

	FruitBox2<?> fruitBox5 = new FruitBox2<Fruit>();
	FruitBox2<? extends Fruit> fruitBox6 = new FruitBox2<Apple>();

	// new 연산자는 타입이 명확해야 객체 생성이 가능하다. (와일드 카드 사용 불가) *오류
	// FruitBox2<? extends Object> fruitBox7 = new FruitBox2<? extends Object>();

}

/**
 * 제너릭 타입의 클래스
 * 
 * @param <T>
 */
class FruitBox2<T extends Fruit> {
	List<T> itemList = new ArrayList();

	public void addItem(T item) {
		this.itemList.add(item);

	}

	public List<T> getItemList() {
		return itemList;
	}

	public void setItemList(List<T> itemList) {
		this.itemList = itemList;
	}

}