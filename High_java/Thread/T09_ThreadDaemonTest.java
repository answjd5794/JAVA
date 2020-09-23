package kr.or.ddit.basic;

public class T09_ThreadDaemonTest {
	public static void main(String[] args) {
		Thread autoSave = new AutoSaveThread();

		// 데몬 스레드로 설정하기 => start() 메서드 호출 전에 설정해야 한다.
		// 데몬 스레드 -> 일반스레드를 보조해주는 역할
		autoSave.setDaemon(true);
		autoSave.start();

		try {
			for (int i = 1; i < 20; i++) {
				System.out.println("작업 : " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메인스레드 종료.");

	}
}

class AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장합니다.");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	}
}
