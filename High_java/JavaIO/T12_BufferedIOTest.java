package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 성능 향상을 위한 보조스트림 예제 (문자 기반읜 Buffered 스트림 사용 예제)
 */
public class T12_BufferedIOTest {
	public static void main(String[] args) {
		try {
			// FileReader => 문자 기반
			// 이클립스에서 만든 자바 프로그램이 시행되는 기본 위치는 해당 '프로젝트폴더'가 기본 위치가 된다.
			FileReader fr = new FileReader("src/kr/or/ddit/basic/T11_BufferedIOTest.java");

/*			int c;

			while ((c = fr.read()) != -1) {
				System.out.println((char) c);
			}
			
			fr.close();*/
			
			// 한 줄씩 읽을수 있도록 해주는 readLine을 이용하기 위해 BufferedReader를 사용.
			BufferedReader br = new BufferedReader(fr);
			String temp = "";
			for (int i= 1; (temp = br.readLine())!=null; i++) {
				System.out.printf("%4d : %s\n",i,temp);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
