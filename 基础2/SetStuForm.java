package date0716;

public class SetStuForm implements Runnable {
	private StuForm stuForm = new StuForm(true);

	public SetStuForm(StuForm stuForm) {
		this.stuForm = stuForm;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			stuForm.set(i++, "a" + i++);
		}

	}

}

