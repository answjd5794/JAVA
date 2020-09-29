package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


/**
 * 프린터 기능 제공 보조 스트림 예제
 * 
 * PrintStream은 데이터를 문자로 출력하는 기능을 수행한다.(System.out)
 * 향상된 기능의 PrintWriter가 추가되었지만 계속 사용된다.
 * PrintWriter가 PrintStream보다 다양한 언어의 문자를 처리하는데 적합하다.
 * 둘 다 기본적으로 autoFlash가 꺼져있다.
 */
public class T14_PrintStreamTest {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		FileOutputStream fos1 = new FileOutputStream("d:/D_Other/print.txt");
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");
		
		// PrintStream은 모든 자료형을 출력할 수 있는 기능을 제공하는 OutputStream의 서브 클래스이다.
		// PrintStream은 IOException을 발생시키지 않는다.
		// println and print 등 메서드 호출시마다 autoFlash 기능을 제공함.
		
		PrintStream out = new PrintStream(fos1);
		out.print("안녕하세요, PrintStream입니다 1. \n");
		out.print("안녕하세요, PrintStream입니다 2. \n");
		out.print("안녕하세요, PrintStream입니다 3. \n");
		out.println(out); // 객체 출력
		out.print(3.14);
		
		out.close();
		
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(fos2, "UTF-8"));
		writer.print("안녕하세요 , PrintWriter입니다. 1 \r\n");
		writer.println("안녕하세요 , PrintWriter입니다. 2 ");
		writer.println("안녕하세요 , PrintWriter입니다. 3 ");
	}
}
