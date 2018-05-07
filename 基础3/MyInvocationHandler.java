package date0802;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Person person;

	public MyInvocationHandler(Person person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始执行"+method.getName()+"方法");
		Object object=method.invoke(person, args);
		System.out.println("执行"+method.getName()+"方法完成");
		return object;
	}

}
