package date0802.LanJieQi;

import java.lang.reflect.Method;

public interface LanJieQi {

	public boolean before(Object targer, Object proxy, Method method, Object[] args);

	public boolean after(Object targer, Object proxy, Method method, Object[] args);
}
