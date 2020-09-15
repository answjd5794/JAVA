package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오 컴퓨터의 숫자는 난수를 이용하여 구한다. 
 * 		(스트라이크는 S, 볼은 B를 출력한다.)
 * 
 * (컴퓨터의 난수가 9 5 7 일 때 실행 예시)
 * 
 * 	숫자 입력 => 3 5 6 1S 0B 
 * 	숫자 입력 => 7 8 9 0S 2B 
 * 	... 
 * 	숫자 입력 => 9 5 7 3S 0B
 * 
 * 	3 번 안에 맞췄군요.
 */
public class T08_BaseBallTest {
	public static void main(String[] args) {
		List<Integer> sysRandom = new ArrayList<Integer>();
//		TreeSet<Integer> sysRandom = new TreeSet<>();

		while (sysRandom.size() < 3) {
			// 1부터 9까지 랜덤하게 중복되지 않는 데이터가 Set에 저장된다.
			int random = (int) (Math.random() * 9 + 1);
			//섞어주기
			Collections.shuffle(sysRandom);
			sysRandom.add(random);
		}
		System.out.println("컴퓨터의 난수 : " + sysRandom);
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("첫 번째 숫자를 입력해주세요.");
			int firstNum = sc.nextInt();
			System.out.println("두 번째 숫자를 입력해주세요.");
			int secondNum = sc.nextInt();
			System.out.println("마지막 숫자를 입력해주세요.");
			int lastNum = sc.nextInt();
			
			TreeSet<Integer> userRandom = new TreeSet<>();
			userRandom.add(firstNum);
			userRandom.add(secondNum);
			userRandom.add(lastNum);
			
			System.out.println("user 입력 : " + userRandom);
			System.out.println();
			
			Iterator it = userRandom.iterator();
		}
		//스트라이크 처리해줄 메서드
		
	}
}
