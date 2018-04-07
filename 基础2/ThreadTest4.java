package date0713;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest4 implements Runnable {
	private int tickets = 100;
	private Lock lock=new ReentrantLock();//������
	public void run() {
		for (int i = 0; i < 10; i++) {
			lock.lock();//���ø÷���ǰ��Ҫ��ȡ�������ö������
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
//		thread.interrupt();//�����̵߳��жϱ��
		thread = new Thread(ticket);
		thread.setName("b");
		thread.start();
	}
}


