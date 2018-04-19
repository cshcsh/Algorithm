package date0716;

public class MyThreadGroup {

	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("yang");
		 MyRunnable runnable=new MyRunnable();
		 Thread thread=new Thread(threadGroup, runnable, "a");
		 System.out.println(thread.getThreadGroup().getName());
		 thread.start();
		 threadGroup.setDaemon(true);
		 System.out.println(Thread.currentThread().getThreadGroup().getName());
		 thread=new Thread(threadGroup, runnable, "b");
		 System.out.println(thread.getThreadGroup().getName());
		 thread.start();
//		 threadGroup.setDaemon(true);
	}
}
