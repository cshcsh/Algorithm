package date0720;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLTest2 {
	private String path="src/date0722/manager.xml";
	public XMLTest2() throws Exception {
		/**
		 * xml�ĺ���Ϊdocument
		 */
		DocumentBuilderFactory facory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = facory.newDocumentBuilder();
		Document document = db.parse(path);// �����ļ�Ϊdocument����
		//System.out.println(doc);
		//test1(document);
		test2(document);
		
	}
	/**
	 * ɾ������
	 * @param document
	 */
	private void test2(Document document) {
		//ɾ�� <name>��</name>
		Node node=document.getElementsByTagName("name").item(0);
		node.getParentNode().removeChild(node);
		write(document);
		
	}
	/**
	 * ��������
	 */
	private void test1(Document document) {
		//�������  <stu id="1001">
		/**
		 * 3.ͨ����ǩ�����ָ����ǩ--node�ڵ�����-----ת����Ԫ�ؽڵ�
		 * 2.���stu��ǩ
		 * 
		 * 1.���id������
		 */
		Element element=(Element) document.getElementsByTagName("stu").item(1);
		String  id=element.getAttribute("id");
		//System.out.println(id);
		/**
		 * ע�⣺document���޸�  δ��Ϊ�޸�
		 */
		element.setAttribute("id", "101");
		/**
		 * ������д���ļ�
		 */
		write(document);
	}
	private void write(Document document) {
		try {
			Transformer transformer=TransformerFactory.newInstance().newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(path));
		
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		

	}

	public static void main(String[] args) {
		try {
			new XMLTest2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
