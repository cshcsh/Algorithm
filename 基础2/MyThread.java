package date0716;

public class MyThread {

	public static void main(String[] args) {

		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "a");
		System.out.println("����߳���" + thread.getThreadGroup().getName());
		thread.start();
		Thread thread2 = new Thread(myRunnable, "b");
		thread2.start();
		System.out.println("����߳���" + thread2.getThreadGroup().getName());
		System.out.println("����߳���" + Thread.currentThread().getThreadGroup().getName());//main���߳�
	}

}
