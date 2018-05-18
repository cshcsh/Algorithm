package date0802;

public class Student2 implements Person {

	private String name;
	
	public Student2(String name) {
		this.name = name;
	}

	@Override
	public void giveMoney() {

		System.out.println(name+"½»°à·Ñ50Ôª");
	}

}
