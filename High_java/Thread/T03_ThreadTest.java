package kr.or.ddit.basic;

/**
 *	스레드 실행시간 체크하기 
 */
public class T03_ThreadTest {
	public static void main(String[] args) {
		Thread th = new Thread(new MyRunner());
		
		// 1. 1970년 1월 1일 0시 0분 0초 (표준시) 로부터 경과한 시간을 밀리세컨드(1/1000)단위로 나타낸다.
		long startTime = System.currentTimeMillis();
		
		th.start(); // 스레드 시작
		try {
			th.join(); // 현재 실행중인 스레드에서 작업 중인 스레드(지금은 th스레드)가 종료될 때까지 기다린다.
					   // main스레드가 실행한다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		
		long endTime = System.currentTimeMillis();
		System.out.println("경과 시간 : " + (endTime - startTime));
	}
}

class MyRunner implements Runnable {

	// 1부터 10억까지의 합을 구하는 메서드
	@Override
	public void run() {
		long sum = 0;
		for (long i = 1L; i < 1000000000; i++) {
			sum += i;
		}
		System.out.println("합계 : " +sum);
	}
	
}