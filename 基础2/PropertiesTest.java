package date0713;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws IOException {

		Properties properties=new Properties();
		File file=new File("D:\\test.properties");
		FileInputStream fileInputStream=new FileInputStream(file);
		properties.load(fileInputStream);
		String value=properties.getProperty("456");
		System.out.println(value);
		
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		properties.setProperty("345", "ppp");
		properties.store(fileOutputStream, "num");
	}

}
