package date0713;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {

	private Logger logger = Logger.getLogger(LogTest.class);

	@Test
	public void test() {
		logger.info("��ͨInfo��Ϣ");
        logger.debug("����debug��Ϣ");
	}
}
