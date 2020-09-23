package kr.or.ddit.basic;

public class T08_ThreadPriorityTest {
	public static void main(String[] args) {
		Thread th1 = new Thread1();
		Thread th2 = new Thread1();
		Thread th3 = new Thread1();
		Thread th4 = new Thread1();
		Thread th5 = new Thread1();
		Thread th6 = new Thread1();
		Thread th7 = new Thread1();
		Thread th8 = new Thread1();
		Thread th9 = new Thread1();
		Thread th10 = new Thread2();
		
		// 우선 순위는 start() 메서드를 호출하기 전에 설정해야 한다.
		th1.setPriority(Thread.MAX_PRIORITY);
		th2.setPriority(Thread.MIN_PRIORITY);
		
		System.out.println("th1의 우선 순위 : " + th1.getPriority());
		System.out.println("th2의 우선 순위 : " + th2.getPriority());
		
		
		try {
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			th5.join();
			th6.join();
			th7.join();
			th8.join();
			th9.join();
			th10.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("최대 우선 순위 : " + Thread.MAX_PRIORITY);
		System.out.println("최소 우선 순위 : " + Thread.MIN_PRIORITY);
		System.out.println("보통 우선 순위 : " + Thread.NORM_PRIORITY);
	}
}

class Thread1 extends Thread {
	@Override
	public void run() {
		// 대문자를 출력하는 반복문
		for (char ch = 'A'; ch < 'Z'; ch++) {
			System.out.println(ch);

			// 시간 떼우는 반복문
			for (long i = 0; i < 1000000000L; i++) {

			}
		}
	}
}

class Thread2 extends Thread {
	@Override
	public void run() {
		// 소문자를 출력하는 반복문
		for (char ch = 'a'; ch < 'z'; ch++) {
			System.out.println(ch);

			// 시간 떼우는 반복문
			for (long i = 0; i < 1000000000L; i++) {

			}
		}
	}
}