package kr.or.ddit.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider.Service;

public class T04_AnnotationTest {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// PrintAnnotation의 static 변수값 출력
		System.out.println(T01_AnnotationTest.id);

		// reflection 기능을 이용한 메서드 실행하기
		Method[] declareMethods = Service.class.getDeclaredMethods();

		for (Method m : declareMethods) {
			System.out.println(m.getName());
			for (int i = 0; i < m.getDeclaredAnnotation(T01_AnnotationTest.class).count(); i++) {
				System.out.println(m.getDeclaredAnnotation(T01_AnnotationTest.class).value());
			}
			System.out.println();
			// 방법 1
//			m.invoke(new Service()); // reflection 기능을 이용한 메서드 설명
			
			// 방법 2
			Class<Service> klass = Service.class;
			Service service = (Service) klass.newInstance();
			m.invoke(service);
		}

	}
}
