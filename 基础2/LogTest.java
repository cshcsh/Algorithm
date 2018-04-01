package date0713;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {

	private Logger logger = Logger.getLogger(LogTest.class);

	@Test
	public void test() {
		logger.info("普通Info信息");
        logger.debug("调试debug信息");
	}
}
