package date0716;

public class StuForm {

	private int id;
	private String name;
	private boolean falg = false;

	public StuForm(boolean falg) {
		this.falg = falg;
	}

	public synchronized void set(int id, String name) {
		/**
		 * 当falg=true时：执行保存的方法
		 */
		if (!this.falg) { // !this.falg=false
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.id = id;
		this.name = name;
		this.falg = false;
		this.notify();

	}

	public synchronized void get() {
		/**
		 * 当falg=false时：执行获得的方法
		 */
		if (this.falg) { // this.falg=true
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this);
		this.falg = true;
		this.notify();

	}

	@Override
	public String toString() {
		return "StuForm [id=" + id + ", name=" + name + ", falg=" + falg + "]";
	}
}
