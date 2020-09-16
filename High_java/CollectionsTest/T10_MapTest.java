package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T10_MapTest {
	public static void main(String[] args) {
/**
 * Map => key값의 value값을 한 쌍으로 관리하는 객체
 * 	   => key값은 중복을 허용하지 않고 순서가 없다.(Set의 활용)
 * 	   => value값은 중복을 허용한다.(List의 활용)
 * 	   => put빼고는 List와 비슷하게 사용한다.
 */
		Map<String, String> map = new HashMap<>();
		
		// 자료 추가 => put(key값, value값);
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
	
		System.out.println("map : " + map);
	
		// 자료 수정 => 데이터를 저장할 key값이 같으면 나중에 입력한 값이 저장된다.
		//		  => put(기존 key값, 새로운 value값)
		
		map.put("addr", "서울");
		System.out.println("map 수정 후: " + map);
	
		// 자료 삭제 => remove(삭제할 키 값)
		map.remove("name");
		System.out.println("map 삭제 후 : " + map);
		
		// 자료 읽기 => get(key값)
		System.out.println("addr : " + map.get("addr"));
		System.out.println("tel : " + map.get("tel"));
		System.out.println("======================================================");
		
		/**
		 * Key 값들을 불러와 자료를 출력하는 방법
		 */
		
		// 방법1 -> keySet() 메서드 이용하기 
		// keySet() 메서드 => Map의 key값들만  읽어와서 Set의 형태로 반환한다.
		Set<String> keySet = map.keySet();
		
		System.out.println("Iterator를 이용한 방법 ");
		
		// Set에서 데이터 가져오는 방법을 씀(keySet 이기때문에)
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key =  it.next();
			System.out.println(key +  " : " + map.get(key));
		}
		
		System.out.println("======================================================");
		
		
		// 방법2 -> Set형의 데이터를 '향상된 for문'을 이용해서 처리한다.
		// Set은 Iterator을 구현했을 때문에 향상된 for문으로 데이터를 하나씩 뽑아올 수 있다.
		System.out.println("향상된 for문를 이용한 방법 ");
		for(String key : keySet) {
			System.out.println(key +  " : " + map.get(key));
		}
		System.out.println("======================================================");
		
		// 방법 3-> value값만 읽어와 출력하기 -> values()메서드 이용하기
		// map.values()
		System.out.println("values() 메서드 이용하는 방법");
		for (String value : map.values()) {
			System.out.println(value);
		}
		
		// 방법 4-> Map에는 Entry라는 내부 클래스가 만들어져 있다. 
		//		    이 Entry클래스에는 key와 value라는 멤버변수로 구성되어 있다.
		//		  Map에서 이 Entry클래스들을 set형식으로 저장하여 관리한다.
		
		// Entry객체 전체를 가져오기(가져온 Entry들은  Set형식으로 저장된다.)
		// => entrySet() 메서드를 이용해 가져온다.
		// Map안의 내부클래스이기 때문에 Map.을 이용해서 불러온다.
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		// 가져온 Entry 객체들을 순서대로 처리하기 위해서 Iterator객체를 가져온다.
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while (entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			
			System.out.println("key 값 : " +entry.getKey());
			System.out.println("value 값 : " +entry.getValue());
		}
	}
}
