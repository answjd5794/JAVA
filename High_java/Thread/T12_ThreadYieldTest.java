package kr.or.ddit.basic;

public class T12_ThreadYieldTest {
	/**
	 * yield() 메서드에 대하여...
	 * 
	 * 1. 현재 실행 대기 중인 동등한 우선순위 이상의 다른 스레드에게 실행 기회를 제공한다.(양보) 
	 * 2. 현재 실행 중인 스레드의 상태를 Runnable 상태로 바꾼다. (Waiting이나 Blocked 상태로 바뀌지 않는다.) 
	 * 3. yield() 메서드를 실행한다고 해서 현재 실행중인 스레드가 곧바로 runnable 상태로 전이된다고 확신할 수 없다.
	 */

	public static void main(String[] args) {
		// 스레드 객체 생성
		Thread th1 = new YieldThread1();
		Thread th2 = new YieldThread2();
		
		th1.start();
		th2.start();
		
	}
}

/**
 * 양보 기능 테스트용 스레드 클래스
 * (양보한다고 모두 양보하는건 확신할 수 없다.)
 *
 */
class YieldThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(" YieldThread1 : " + i );
			Thread.yield();
			// -> 동일함 yield();
		}

	}

}

/**
 * 양보 안하는 테스트용 스레드 클래스
 *
 */
class YieldThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(" YieldThread2 : " + i + " - 1이 양보함");
		}
	}
}