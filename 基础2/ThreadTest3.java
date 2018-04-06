package date0713;

class MyRunnable implements Runnable {
	int tak = 100;

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				
				//多线程就是分时利用CPU，宏观上让所有线程一起执行 ，也叫并发。
				
				//JVM的垃圾回收线程就是典型的后台线程。后台线程有个特征：如果所有的前台线程都死亡，后台线程会自动死亡。
				
				//java线程中yield(),sleep(),wait()区别详解
				/*1、sleep()
				使当前线程（即调用该方法的线程）暂停执行一段时间，让其他线程有机会继续执行，但它并不释放对象锁。
				也就是说如果有synchronized同步快，其他线程仍然不能访问共享数据。注意该方法要捕捉异常。
				例如有两个线程同时执行(没有synchronized)一个线程优先级为MAX_PRIORITY，另一个为MIN_PRIORITY，
				如果没有Sleep()方法，只有高优先级的线程执行完毕后，低优先级的线程才能够执行；但是高优先级的线程sleep(500)后，
				低优先级就有机会执行了。
				总之，sleep()可以使低优先级的线程得到执行的机会，当然也可以让同优先级、高优先级的线程有执行的机会。
				sleep(long)是不会释放锁标志的。
				
				 */
				Thread.currentThread().sleep(1000);
				//2、join()
				//join()方法使调用该方法的线程在此之前执行完毕，也就是等待该方法的线程执行完毕后再往下继续执行。注意该方法也需要捕捉异常。
				//比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
				
				//3、yield()
				//该方法与sleep()类似，只是不能由用户指定暂停多长时间，并且yield（）方法只能让同优先级的线程有执行的机会。
				//yield()只是使当前线程重新回到可执行状态，所有执行yield()的线程有可能在进入到可执行状态后马上又被执行，
				//所以yield()方法只能使同优先级的线程有执行的机会
				//yield()也不会释放锁标志。
				//yield()方法对应了如下操作；先检测当前是否有相同优先级的线程处于同可运行状态，如有，则把CPU的占有权交给次线程，
				//否则继续运行原来的线程，所以yield()方法称为“退让”，它把运行机会让给了同等级的其他线程。


				
				//wait()和notify()、notifyAll() 线程 对象等待池  释放对象锁标示  锁标志等待池  获取锁标志
				//这三个方法用于协调多个线程对共享数据的存取，所以必须在synchronized语句块内使用。synchronized关键字用于保护共享数据，
				//阻止其他线程对共享数据的存取，但是这样程序的流程就很不灵活了，如何才能在当前线程还没退出synchronized数据块时让
				//其他线程也有机会访问共享数据呢？此时就用这三个方法来灵活控制。
				//wait()方法使当前线程暂停执行并释放对象锁标示，让其他线程可以进入synchronized数据块，当前线程被放入对象等待池中。
				//当调用notify()方法后，将从对象的等待池中移走一个任意的线程并放到锁标志等待池中，只有锁标志等待池中线程能够获取锁标志；
				//如果锁标志等待池中没有线程，则notify()不起作用。
				//notifyAll()则从对象等待池中移走所有等待那个对象的线程并放到锁标志等待池中。
				
				//wait() 当前线程暂停执行  释放对象锁标示synchronized  当前线程被放入对象等待池中  
				//notify()  从对象等待池中移走一个任意的线程并放到锁标志等待池中   锁标志等待池中线程能够获取锁标志synchronized
				
				Thread.yield();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			tak--;
			System.out.println(Thread.currentThread().getName() + ":" + tak);
		}

	}

	public int getTak() {
		return tak;
	}

}

public class ThreadTest3 {

	public static void main(String[] args) {

		MyRunnable runnable = new MyRunnable();
		Thread thread1 = new Thread(runnable);
		thread1.start();
		Thread thread2 = new Thread(runnable);
		thread2.start();
		int tak = runnable.getTak();
		System.out.println(tak);
	}

}
