package date0802;

public class Test {

	public static void main(String[] args) {

		Action action=new Teacher();
		
		MyProxy myProxy=new MyProxy();
		action=(Action) myProxy.bind(action);
		action.action();
	}

}
