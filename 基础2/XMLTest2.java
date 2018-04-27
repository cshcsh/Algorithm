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
		 * xml的核心为document
		 */
		DocumentBuilderFactory facory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = facory.newDocumentBuilder();
		Document document = db.parse(path);// 解析文件为document对象
		//System.out.println(doc);
		//test1(document);
		test2(document);
		
	}
	/**
	 * 删除功能
	 * @param document
	 */
	private void test2(Document document) {
		//删除 <name>张</name>
		Node node=document.getElementsByTagName("name").item(0);
		node.getParentNode().removeChild(node);
		write(document);
		
	}
	/**
	 * 操作属性
	 */
	private void test1(Document document) {
		//获得属性  <stu id="1001">
		/**
		 * 3.通过标签名获得指定标签--node节点类型-----转换成元素节点
		 * 2.获得stu标签
		 * 
		 * 1.获得id的属性
		 */
		Element element=(Element) document.getElementsByTagName("stu").item(1);
		String  id=element.getAttribute("id");
		//System.out.println(id);
		/**
		 * 注意：document以修改  未见为修改
		 */
		element.setAttribute("id", "101");
		/**
		 * 将对象写入文件
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
