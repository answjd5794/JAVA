package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/* 로또를 구매하는 프로그램 작성하기
		 
		 사용자는 로또를 구매할 때 구매할 금액을 입력하고
		 입력한 금액에 맞게 로또번호를 출력한다.
		 (단, 로또 한장의 금액은 1000원이고 거스름돈도 계산하여
		      출력한다.)

			==========================
		         	Lotto 프로그램
			--------------------------
			 1. Lotto 구입
			  2. 프로그램 종료
			==========================		 
			메뉴선택 : 1  <-- 입력
					
			 Lotto 구입 시작
				 
			(1000원에 로또번호 하나입니다.)
			금액 입력 : 2500  <-- 입력
					
			행운의 로또번호는 아래와 같습니다.
			로또번호1 : 2,3,4,5,6,7
			로또번호2 : 20,21,22,23,24,25
					
			받은 금액은 2500원이고 거스름돈은 500원입니다.
					
		   	 ==========================
		       	  Lotto 프로그램
			--------------------------
			  1. Lotto 구입
			  2. 프로그램 종료
			==========================		 
			메뉴선택 : 2  <-- 입력
				
			감사합니다
 */
public class T10_LottoTest {
	public static void main(String[] args) {
		while (true) {
			// 뷰
			System.out.println("==========================");
			System.out.println("\tLotto 프로그램");
			System.out.println("--------------------------");
			System.out.println("  1. Lotto 구입");
			System.out.println("  2. 프로그램 종료");
			System.out.println("==========================");
			System.out.println("메뉴 선택 :");

			int num = 0;
			// 예외처리
			try {
				// 사용자한테 입력받음
				Scanner sc = new Scanner(System.in);
				num = sc.nextInt();
				// 입력받은 번호가 올바르지 않을 때 catch
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("입력이 올바르지 않습니다!! 해당하는 숫자를 입력해주세요.");
			}

			switch (num) {
			case 1:
				// 로또를 구입하는 메서드
				lottoGet();
				break;
			case 2:
				// 프로그램을 종료
				System.exit(2);
				break;

			default:
				break;
			}

		}
	}

	/**
	 * 로또를 구입하는 메서드
	 * 
	 * @method lottoGet
	 * @return void
	 * @author 강문정
	 */
	// 로또를 구입하는 메서드
	private static void lottoGet() {
		System.out.println("==========================");
		System.out.println("\t로또 구입 시작");
		System.out.println("--------------------------");
		System.out.println("   1000원에 로또 하나입니다.");
		System.out.println("==========================");
		System.out.println("금액 입력 : ");

		// 사용자한테 로또 금액 입력받음
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();

		// 만약 money가 1000원 이상일 때 1000원당 하나씩 행운의 로또번호를 부여한다.
		if (money >= 1000) {
			//money/1000 보다 적게 행운의 숫자를 부여한다.
			for (int i = 0; i < money / 1000; i++) {
				//로또 번호가 순서가 없기 때문에 Set 사용
				Set<Integer> lotto = new HashSet<>();
				while (lotto.size() < 7) {
					// 중복되지 않은 5개의 데이터 set에서 저장
					int lottoNum = (int) (Math.random() * 45 + 1);
					lotto.add(lottoNum);
				}
				System.out.println("행운의 Lotto번호 :" + lotto);
			}
			//받은 금액 : money , 거스름돈 : money/1000 의 나머지=> money%1000 
			System.out.println("받은 금액은 " + money + "이고 거스름돈은 " + money%1000 + "입니다.");

		} else {
			System.out.println("돈 더 갖고와.");
		}

	}

}
