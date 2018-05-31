package date0802.LanJieQi;

import java.lang.reflect.Method;

public class LanJieQi1 implements LanJieQi {

	@Override
	public boolean before(Object targer, Object proxy, Method method, Object[] args) {
		System.out.println("开启事物");
		return true;

	}

	@Override
	public boolean after(Object targer, Object proxy, Method method, Object[] args) {
		System.out.println("提交事物");
		return true;

	}

}
