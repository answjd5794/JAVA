package kr.or.ddit.basic;

public class T04_ThreadTest {
	/**
	 * 1-20억 까지 합계를 구하는데 걸린 시간 체크하기 전체 합계를 구하는 작업을 단독으로 처리했을 때(1개의 스레드를 사용했을 때)의 여러
	 * 스레드로 분할해서 작업할 때의 시간을 확인해보자.
	 */
	public static void main(String[] args) {
		// 단독으로 처리할 때
		SumThread st = new SumThread(1L, 2000000000L);

		long startTime = System.currentTimeMillis();
		st.start();
		try {
			st.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();
		System.out.println("싱글 스레드 걸리는 시간 : " + (endTime - startTime));
		System.out.println("==========================================");

		// 여러 스레드가 협력해서 처리했을 때...
		SumThread[] sumThs = new SumThread[] { 
				new SumThread(1L, 500000000L), 
				new SumThread(500000000L, 1000000000L),
				new SumThread(1000000001L, 1500000000L), 
				new SumThread(1500000000L, 2000000000L) 
		};

		startTime = System.currentTimeMillis();
		for (SumThread th : sumThs) {
			th.start();
		}
		for (SumThread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("멀티 스레드 걸리는 시간 : " + (endTime - startTime));
		System.out.println("==========================================");
	}
}

class SumThread extends Thread {
	private long max, min;

	public SumThread(long min, long max) {
		super();
		this.max = max;
		this.min = min;
	}

	@Override
	public void run() {
		long sum = 0L;
		for (long i = min; i < max; i++) {
			sum += i;
		}
		System.out.println(min + " ~ " + max + " 까지의 합 :" + sum);
	}

}
