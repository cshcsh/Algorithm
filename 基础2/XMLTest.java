package date0720;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import date0722.XmlUtil;

public class XMLTest {
	
	public XMLTest() throws Exception {
		/**
		 * xml�ĺ���Ϊdocument
		 */
		DocumentBuilderFactory facory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = facory.newDocumentBuilder();
		Document doc = db.parse("src/date0722/manager.xml");// �����ļ�Ϊdocument����
		System.out.println(doc);

	}

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
/*		try {
			new XMLTest();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}
}
