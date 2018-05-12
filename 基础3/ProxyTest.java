package date0802;

import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {

		Person person=new Student2("hhh");
		Person person2=new Student2("uuu");
		MyInvocationHandler my=new MyInvocationHandler(person2);
		Person proxy=(Person) Proxy.newProxyInstance(Person.class.getClassLoader(), person2.getClass().getInterfaces(), my);
		proxy.giveMoney();
	}

}
