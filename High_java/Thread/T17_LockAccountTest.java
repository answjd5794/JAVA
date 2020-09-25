package kr.or.ddit.basic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 은행의 입출금을 스레드로 처리하는 예제 (Lock을 이용한 동기화 처리 방법)
 */
public class T17_LockAccountTest {
	public static void main(String[] args) {
		LockAccount lAcc = new LockAccount();
		lAcc.setBalance(10000);
		
		BankThread2 th1 = new BankThread2(lAcc);
		BankThread2 th2 = new BankThread2(lAcc);
		
		th1.start();
		th2.start();
	}
}

/**
 * 입출금을 담당하는 클래스
 */
class LockAccount {
	private int balance; // 잔액이 저장될 변수

	// lock 객체 생성 => 되도록이면 private final로 만든다.
	private final ReentrantLock lock = new ReentrantLock();

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금을 담당하는 메서드
	public void deposit(int money) {
		// Lock 객체의 lock() 메서드가 동기화의 시작이고, unlock()메서드가 동기화의 끝을 나타낸다.
		// lock() 메서드로 동기화를 설정한 곳에서는 반드시 unlock()메서드로 해제해 주어야 한다.

		lock.lock(); // 시작
		balance += money;
		lock.unlock();
	}

	// 출금을 담당하는 메서드
	public boolean withdraw(int money) {
		lock.lock();
		boolean chk = false;

		// try-catch블럭을 사용할 경우에는 unlock메서드 호출은 finally 블럭에서 하도록 한다.
		try {
			if (balance >= money) {
				for (int i = 0; i < 1000000000; i++) {
				}
				balance -= money;
				System.out.println("메서드 안에서 : " + getBalance());
				chk = true;
			}
		} catch (Exception e) {
			chk = false;
			
		} finally {
			lock.unlock();
		}
		
		return chk;
	}
}

/**
 * 은행 업무를 담당하는 스레드
 */
class BankThread2 extends Thread {
	private LockAccount lAcc;

	public BankThread2(LockAccount lAcc) {
		this.lAcc = lAcc;
	}
	
	@Override
	public void run() {
		boolean result = lAcc.withdraw(6000);
		System.out.println("스레드 안에서 result = " + result 
				+ ", balance = " + lAcc.getBalance());
	}
}
