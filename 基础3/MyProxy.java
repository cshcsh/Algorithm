package date0802;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {

	private Object target=null;
	
	public Object bind(Object target){
		this.target=target;
		Object object=Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
		return object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		System.out.println("����");
		Object obj = method.invoke(target, args);
		System.out.println("��Ҳ����");
		return obj;
	}

}
