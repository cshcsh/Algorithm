package date0716;

public class MyRunnable implements Runnable {
	int tak = 100;

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.currentThread().sleep(1000);
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
