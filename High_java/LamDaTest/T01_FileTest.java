package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class T01_FileTest {
	public static void main(String[] args) throws IOException {
		// file 객체 만들기 연습
		
		// 1. new File(String 파일 또는 경로명)
		// =>  디렉토리와 디렉토리 사이 또는 디렉토리와 파일 사이 구분자는  '\'을 사용하거나 '/'을 사용할 수 있다.
		// 단, \를 쓸 경우는 2개씩 써 줘야 한다.
		File file =  new File("d:/D_Oter/test.txt");
		System.out.println("파일 명 : " + file.getName());
		System.out.println("파일 여부 : " + file.isFile());
		System.out.println("디렉토리(폴더) 여부 : " + file.isDirectory());
		System.out.println("----------------------------------------");
		System.out.println();
		
		File file2 = new File("d:/D_Oter");
		System.out.println(file2.getName() + " 은 ");
		if (file2.isFile()) {
			System.out.println(" 파일");
		} else {
			System.out.println("디렉토리(폴더)");
		}
		System.out.println("----------------------------------------");
		System.out.println();
		
		// 2. new File(File parent, String child)
		// => 'parent' 디렉토리 안에 있는 'child'파일 또는 디렉토리를 갖는다.
		File file3 = new File(file2, "test.txt");
		System.out.println(file3.getName() + "의 용량 크기 : " + file3.length());
		
		// 3. new File(String, String child)
		File file4 = new File("d:/D_Oter", "text.txt");
		System.out.println("절대 경로 : " + file4.getAbsolutePath());
		System.out.println("경       로 : " + file4.getPath());
		System.out.println("표준 경로 : " + file4.getCanonicalPath());
		System.out.println("현재 클래스의 url : " + T01_FileTest.class.getResource("T01_FileTest"));
	
		/**
		 * 디렉토리 폴더 만들기
		 * 1. mkdir() => file 객체의 경로 중 마지막 위치의 디렉토리를 만든다.
		 * 			  => 중간의 경로가 모두 미리 만들어져 있어야 한다.
		 * 2. mkdirs() => 중간의 경로가 없다. 중간의 경로도 새롭게 만ㄷ든 위치의 디렉토리를 만들어준다.
		 * 
		 * 두 메서드 모두 만들어지면 true, 실패하면 false를 만든다.
		 */
		
		File file5 = new File("d:/D_Other/연습용");
		if (file5.mkdir()) {
			System.out.println(file5.getName() + "만들기 성공!");
		} else {
			System.out.println(file5.getName() + "만들기 실패 ㅠㅠ");
		}
		System.out.println();
		
		
		File file6 = new File("d:/D_Other/test/java/src");
		if (file6.mkdir()) {
			System.out.println(file6.getName() + "만들기 성공!");
		} else {
			System.out.println(file6.getName() + "만들기 실패 ㅠㅠ");
		}
		System.out.println();
		
	
	
	}
}
