package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * 외부의 properties 파일을 읽어와 properties 객체로 처리하기
 */
public class T03_PropertiesTest {
	public static void main(String[] args) {
		// 읽어 올 정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();

		// 읽어 올 파일명을 이용한 File 객체 생성
		File file = new File("res/db.properties");

		try {
			// 파일 읽기를 수행할 FileInputStream 객체 생성
			FileInputStream fis = new FileInputStream(file);

			// Properties 객체로 파일 내용 읽기
			// 파일 내용을 읽어와 Key, value 값으로 분류 한 후 Properties객체에 담아준다.
			prop.load(fis);

			// 읽어 온 자료 출력하기
			// key 값만 읽어와 Enumeration 객체로 반환하기
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();

			// key 값 갯수만 반복해서 값 출력하기
			// keys.hasMoreElement() => 다음 포인터 위치에 자료가 있으면 true 없으면 false 반환
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + " => " + value);

			}
			System.out.println("== 출력 끝 ==");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
