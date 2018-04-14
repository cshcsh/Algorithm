package date0716;

public class GetStuForm implements Runnable {
	private StuForm stuForm = new StuForm(true);

	public GetStuForm(StuForm stuForm) {
		this.stuForm = stuForm;
	}

	@Override
	public void run() {
		while (true) {
			stuForm.get();
		}

	}

}
