package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/**
 * 컴퓨터와 가위바위보를 진행하는 프로그램을 작성
 * 
 * 컴퓨터의 가위바위보는 난수를 이용해서 구하고, 사용자의 가위바위보는 showInputDialog를 통해서 입력받는다. 
 * 입력시간은 5초로 제한하고 카운트 다운을 진행한다. 5초안에 입력이 없으면 게임을 진 것으로 처리한다.
 * 
 * 5초오 안에 입력이 완료되면 승패를 출력한다.
 * 
 * 결과 예시) === 결과 === 컴퓨터 : 가위 당 신 : 바위 결과 : 당신이 이겼습니다!
 *
 */
public class T07_ThreadGame {
	public static boolean inputCheck = false;

	public static void main(String[] args) {
		Thread th1 = new Game();
		Thread th2 = new CountGame();

		th1.start();
		th2.start();
	}
}

/**
 * 사용자의 시간을 재는 스레드
 */
class CountGame extends Thread {
	@Override
	public void run() {
		// 카운트다운하는 for문
		for (int i = 5; i >= 1; i--) {
			// 입력이 완료되었는지 여부를 검사하고 입력이 완료되면 run() 메서드를 종료시킨다. 즉 현재 스레드가 종료
			if (T07_ThreadGame.inputCheck == true) {
				return; // run() 메서드가 종료되면 스레드도 같이 종료된다.
			}
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초동안 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 10초가 경과되었음에도 입력이 없으면 프로그램을 종료한다.
		System.out.println("5초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}

/**
 * 사용자의 데이터를 입력받는 스레드
 */
class Game extends Thread {
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("가위 바위 보 중 하나를 5초안에 입력하세요.");
		System.out.println("입력한 값은 " + str + "입니다.");
		// 입력이 완료되면 inputCheck 변수를 true로 변경한다.
		if (T07_ThreadGame.inputCheck = true) {
			// 컴퓨터가 1-> 가위, 2-> 바위, 3-> 보
			int computer = (int) (Math.random() * 2 + 1);

			// 난수로 받은 computer를 String으로 변환
			String com = null;
			if (computer == 1) {
				com = "가위";
			} else if (computer == 2) {
				com = "바위";
			} else if (computer == 3) {
				com = "보";
			}

			// String으로 확인
			switch (com) {
			case "가위":
				if (str.equals("가위") == true) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("비겼습니다.");

				} else if (str.equals("바위") == true) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("당신이 이겼습니다.");

				} else if (str.equals("보") == true) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("컴퓨터가 이겼습니다.");

				}

				break;

			case "바위":
				if (str.equals("바위")) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("비겼습니다.");

				} else if (str.equals("보") == true) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("당신이 이겼습니다.");

				} else if (str.equals("가위") == true) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("컴퓨터가 이겼습니다.");

				}
				break;

			case "보":
				if (str.equals("보")) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("비겼습니다.");

				} else if (str.equals("가위") == true) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("당신이 이겼습니다.");

				} else if (str.equals("바위") == true) {
					System.out.println("=== 결과 ===");
					System.out.println(" 컴퓨터 :" + com);
					System.out.println(" 당   신:" + str);
					System.out.println("컴퓨터가 이겼습니다.");
				}
				break;
			}
		}
	}
}