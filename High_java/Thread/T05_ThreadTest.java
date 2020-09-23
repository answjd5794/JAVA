package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/**
 * 단일 스레드에서의 사용자 입력 처리
 *
 */
public class T05_ThreadTest {
	public static void main(String[] args) {

		// 입력을 원하는 창 (prompt와 동일)
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		// 누르는 순간 변수에 저장
		System.out.println("입력한 값은 " + str + "입니다.");

		// 카운트 다운 for문
		for (int i = 10; i >= 1; i--) {
			// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면 run()메서드를 종료시킨다.
			// 즉, 현재 스레드가 종료
			System.out.println(i);
			try {
				Thread.sleep(2000); // 1초동안 멈춤
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
