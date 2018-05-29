package date0802.staticProxy;

public class StudentProxyTest {

	public static void main(String[] args) {

		Persion persion=new Student("csh");
		Persion persionProxy=new StudentProxy(persion);
		persionProxy.giveMoney();
	}

}
