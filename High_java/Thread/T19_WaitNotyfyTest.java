package kr.or.ddit.basic;

/**
 *  wait() -> 동기화 영역에서 락을 풀고 Wait-Set영역(공유 객체 존재)로 이동시킨다.
 * 
 *  notify() 또는 notifyAll() 메서드 -> Wait-Set 영역에 맞는 스레드를 깨워서 실행할 수 있도록 한다.
 *  (notify()는 하나, notifyAll()은 Wait-set에 있는 전부를 깨운다.)
 *  
 *  => Wait()과 notify(), notifyAll()메서드는 동기화 영역안에서만 실행할 수 있고,
 *     Object 클래스에서 제공하는 메서드이다.
 */
public class T19_WaitNotyfyTest {
	public static void main(String[] args) {
		
		WorkObject workObj = new WorkObject();
		
		ThreadA tha = new ThreadA(workObj);
		ThreadB thb = new ThreadB(workObj);
		
		tha.start();
		thb.start();
	
	}
}

// 공통으로 사용핦 객체
class WorkObject {
	public synchronized void methodA(){
		System.out.println("methodA()에서 작업중...");
		
		// Wait-set에 있는 대기중인 스레드를 깨운다 (없으면 그냥 넘어감) (상대방을 깨우고)
		notify();

		try {
			// 동기화 영역에서 락을 풀고 Wait-Set영역(공유 객체 존재)로 이동시킨다. (나는 대기실로 감)
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB(){
		System.out.println("methodB()에서 작업중...");
		
		// Wait-set에 있는 대기중인 스레드를 깨운다 (없으면 그냥 넘어감) (상대방을 깨우고)
		notify();
		
		try {
			// 동기화 영역에서 락을 풀고 Wait-Set영역(공유 객체 존재)로 이동시킨다. (나는 대기실로 감)
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * WorkObject의 methodA()만 호출하는 메서드
 */
class ThreadA extends Thread {
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			workObj.methodA();
		}
		System.out.println("=== ThreadA 종료 ===");
	}
}
/**
 * WorkObject의 methodB()만 호출하는 메서드
 */
class ThreadB extends Thread {
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			workObj.methodB();
		}
		System.out.println("스레드B 종료");
	}
}