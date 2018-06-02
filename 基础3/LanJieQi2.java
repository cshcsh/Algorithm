package date0802.LanJieQi;

import java.lang.reflect.Method;

public class LanJieQi2 implements LanJieQi {

	@Override
	public boolean before(Object targer, Object proxy, Method method, Object[] args) {
		System.out.println("连接数据");
		return true;

	}

	@Override
	public boolean after(Object targer, Object proxy, Method method, Object[] args) {
		System.out.println("关闭资源");
		return true;

	}

}
