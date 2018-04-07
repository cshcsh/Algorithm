package date0713;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest4 implements Runnable {
	private int tickets = 100;
	private Lock lock=new ReentrantLock();//重入锁
	public void run() {
		for (int i = 0; i < 10; i++) {
			lock.lock();//调用该方法前需要获取到创建该对象的锁
			System.out.println(Thread.currentThread().getName() + ":" + tickets--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest4 ticket = new ThreadTest4();
		Thread thread = new Thread(ticket);
		thread.setName("a");
		thread.start();
//		thread.interrupt();//设置线程的中断标记
		thread = new Thread(ticket);
		thread.setName("b");
		thread.start();
	}
}


