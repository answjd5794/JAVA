package kr.or.ddit.basic;

public class T20_WaitNotifyTest {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread pth = new ProducerThread(dataBox);
		ConsumerThread cth = new ConsumerThread(dataBox);
		
		pth.start();
		cth.start();
	}
}

// 데이터를 공통으로 사용하는 클래스
class DataBox {
	private String data;

	// data가 null 일 때 data값을 반환하는 메서드
	// data를 가져오는 getData()
	public synchronized String getData() {
		if (data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		String returnData = data;
		System.out.println("읽어온 데이터 : " + returnData);
		// data를 null로 초기화 -> 데이터를 갖고 왔다는 의미
		data = null;
		System.out.println(Thread.currentThread().getName() + "notify() 호출");
		notify(); 

		return returnData;

	}

	// data가 null 일 때 data값을 반환하는 메서드
	public synchronized void setData(String data) {
		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.data = data;
		System.out.println("세팅한 데이터" + this.data);
		System.out.println(Thread.currentThread().getName() + "notify() 호출");
		notify(); // -> 다른 스레드 깨우고 자기는 들어가기
	}
}
/**
 * 데이터를 넣는 스레드 
 */
class ProducerThread extends Thread {
	private DataBox databox;

	public ProducerThread(DataBox databox) {
		super("ProducerThread");
		this.databox = databox;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			String data = "Data-" + i;
			System.out.println("dataBox.setData(" + data + ") 호출");
			databox.setData(data);
		}
	}
}

/**
 * 데이터를 읽어오는 스레드
 */
class ConsumerThread extends Thread {
	private DataBox dataBox;

	public ConsumerThread(DataBox dataBox) {
		super("ConsumerThread");
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			String data = dataBox.getData();
			System.out.println("dataBox.getData() : " + data);
		}
	}
}