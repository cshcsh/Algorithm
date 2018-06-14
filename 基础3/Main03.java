package date0803;


class C{

	private int age;
	private String name;
	private static String dec;
	public static final String HEIGHT="100";
	public C() {
	}
	public C(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public void say(){
		System.out.println(this.age);
	}
	
}

public class Main03{

	public static void main(String[] args) {

		C c=new C();
		c.say();
		
	}
}
