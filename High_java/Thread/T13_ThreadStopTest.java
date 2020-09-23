package kr.or.ddit.basic;

public class T13_ThreadStopTest {
/**
 * Thread의  stop() 메서드를 호출하면 쓰레드가 바로 멈춘다.
 * 이때 사여ㅛㅇ하던 자원을 정리하지 못하고 프로그램이 종료돼서 나중에 실행되는 프로그램에 영향을 미칠 수 있다.
 * 그래서 현재 stop() 메서드는 추천되지 않는다.
 */
	public static void main(String[] args) {
		ThreadStopEx1 th = new ThreadStopEx1();
		th.start();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		th.stop(); //  작대기가 그어져있다.
		th.setStop(true);
	}
}

class ThreadStopEx1 extends Thread {
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {
		while (!stop) {
			System.out.println("스레드 처리중");

		}
		System.out.println("지원 정리중");
		System.out.println("실행 종료");

	}

}