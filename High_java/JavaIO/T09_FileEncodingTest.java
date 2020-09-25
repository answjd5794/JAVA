package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * InputStreamReader 객체는 파일의 인코딩 방식을 지정할 수 있다.
 * 형식 : new InputStreamReader(바이트 기반 스트림 객체, 인코딩 방식)
 * 
 * 인코딩 방식
 * 한글 인코딩 방식은 크게 UTF-8 과 EUC-KR 방식 두가지가 있다.
 * 원래 한글 윈도우는 cp949 방식을 사용했는데, 윈도우를 개발안 마이크로소프트에서 EUC-KR 방식에서 확장하였기 때문에
 * MS949라고도 부른다.
 * CP949는 EUC-KR의 확장이며, 하휘 호환성이 있다.
 * 
 * MS949 -> 윈도우의 기본 한글 인코딩 방식(ANSI 계열)
 * UTF-8 -> 유니코드 UTF-8 인코딩 방식(영문자 및 숫자: 1byte, 한글: 3byte) => 가변식
 * US-ASCII -> 영문자 전용 인코딩 방식
 * 
 * ANSI는 영어를 표기하기 위해 만든 코드 규격으로 자체에 한글이 없었다가 나중에 여기에 EUC-KR(유닉스 계열), CP949(윈도우)라는 식으로 한글이 포함되어 있다.
 */
public class T09_FileEncodingTest {
	public static void main(String[] args) {
		// 파일 인코딩을 이용하여 읽어오기
		// InputStreamReader 스트림 => 바이트 기반 스트림을 문자 기반 스트림으로 변환해주는 보조 스트림
		FileInputStream fin = null;
		InputStreamReader isr = null;
		
		try {
			/*
			 * fileInputStream 객체를 생성한 수 이 객체를 매개변수로 받는 InputStreamReader 객체를 생성한다.
			 * (바이트 입력 스트림에 연결 되어 무낮 입력 스트림은 Reader로 변환 시키는 보조 스트림)
			 */
			
			// fin = new FileInputStream("d:/D_other/test_utf-8.txt");
			fin = new FileInputStream("d:/D_other/test_ansi.txt");
			isr = new InputStreamReader(fin);
			
			int c;
			while ((c=isr.read()) != -1) {
				System.out.println((char)c);
			}
			System.out.println();
			System.out.println("출 력 끝 !!");
			isr.close();  // 보조스트림만 닫으면 기반스트림이 알아서 닫아지기 때문에 굳이 기반스트림까지 close안해줘도 된다.
		} catch (Exception e) {
		}
		
		
	}
}
