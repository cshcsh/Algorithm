package date0802.staticProxy;

public class StudentProxy implements Persion{

	private Student student;
	
	public StudentProxy(Persion persion) {
		if(Student.class==persion.getClass()){
			this.student = (Student) persion;
		}
	}

	@Override
	public void giveMoney() {
		student.giveMoney();
	}

	
}
