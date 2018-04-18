package date0716;

public class MyThread {

	public static void main(String[] args) {

		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "a");
		System.out.println("获得线程组" + thread.getThreadGroup().getName());
		thread.start();
		Thread thread2 = new Thread(myRunnable, "b");
		thread2.start();
		System.out.println("获得线程组" + thread2.getThreadGroup().getName());
		System.out.println("获得线程组" + Thread.currentThread().getThreadGroup().getName());//main主线程
	}

}
