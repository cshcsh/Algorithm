package date0716;

public class TestStuForm {

	public static void main(String[] args) {
		StuForm stuForm = new StuForm(false);
		Thread thread1=new Thread(new SetStuForm(stuForm));
		Thread thread2=new Thread(new GetStuForm(stuForm));
		thread1.start();
		thread2.start();
	}

}
