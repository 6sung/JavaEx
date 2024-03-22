
public class ThreadExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable());
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("쓰레드가 실행할 다른 코드");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		t2.start();
		System.out.println("Hello");
		System.out.println(Thread.currentThread().getName());
		
		MyThread t3 = new MyThread();
		t3.start();
	}
}

class MyThread extends Thread {
	public void run() {
		System.out.println("1234567890");
	}
}


class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("-----------------");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}