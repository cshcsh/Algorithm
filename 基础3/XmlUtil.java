package date0722;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlUtil {

	public static Document getDocument(String path) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(path);
		return document;
	}

	public static void findAll(Document document) {

		String string = document.getBaseURI().substring(document.getBaseURI().lastIndexOf("/") + 1,
				document.getBaseURI().lastIndexOf("s."));
		NodeList list = document.getElementsByTagName(string);
		String[][] info = new String[list.getLength()][list.item(0).getChildNodes().getLength()];
		int count=0;
		for (int i = 0; i < list.getLength(); i++) {
			Node fatherNode = list.item(i);
			NodeList childNodes = fatherNode.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				Node childNode = childNodes.item(j);

				if (count<4&&(childNode instanceof Element)) {
					Element element = (Element) childNode;
					System.out.print("\t" + element.getAttribute("name"));
					count++;
				}

				info[i][j] = childNode.getTextContent();
				if (info[i][j].contains("\t") || info[i][j].contains("\n")) {
					info[i][j] = info[i][j].replaceFirst("\t", "");
					info[i][j] = info[i][j].replaceAll("\n", "");
				}
			}
		}
		System.out.println();
		for (int i = 0; i < info.length; i++) {
			for (int j = 0; j < info[i].length; j++) {
				System.out.print(info[i][j]);
			}
			System.out.println();
		}
	}
	public static void add(Document document) throws TransformerException{
		String string = document.getBaseURI().substring(document.getBaseURI().lastIndexOf("/") + 1,
				document.getBaseURI().lastIndexOf("s."));
		NodeList list = document.getElementsByTagName(string);
		String fatherNodeName=list.item(0).getNodeName();
		Element fatherElement=document.createElement(fatherNodeName);
		fatherElement.setAttribute("id",String.valueOf(list.getLength()+1));
		for(int i=0;i<list.item(0).getChildNodes().getLength();i++){
			if(list.item(0).getChildNodes().item(i) instanceof Element){
				String childNodeName=list.item(0).getChildNodes().item(i).getNodeName();
				Element childElement=document.createElement(childNodeName);
				Scanner scanner=new Scanner(System.in);
				String textContent=scanner.nextLine();
				childElement.setTextContent(textContent);
				Element element=(Element) list.item(0).getChildNodes().item(i);
				String attribute=element.getAttribute("name");
				childElement.setAttribute("name", attribute);
				fatherElement.appendChild(childElement);
			}
		}
		list.item(0).getParentNode().appendChild(fatherElement);
		write(document);
		System.out.println("添加成功");
	}

	public static void delete(Document document, String id) throws TransformerException {
		String string = document.getBaseURI().substring(document.getBaseURI().lastIndexOf("/") + 1,
				document.getBaseURI().lastIndexOf("s."));
		NodeList list = document.getElementsByTagName(string);
		int i=0;
		for (; i < list.getLength(); i++) {
			if (list.item(i) instanceof Element) {
				Element element = (Element) list.item(i);
				if (element.getAttribute("id").equals(id)) {
					list.item(i).getParentNode().removeChild(list.item(i));
					System.out.println("删除成功");
					write(document);
					findAll(document);
					break;
				}
			}
		}
		if(i==list.getLength()){
			System.out.println("无此id");
			findAll(document);
		}
	}
	
	public static void update(Document document,String id) throws TransformerException{
		String string = document.getBaseURI().substring(document.getBaseURI().lastIndexOf("/") + 1,
				document.getBaseURI().lastIndexOf("s."));
		NodeList list = document.getElementsByTagName(string);
		int i=0;
		Scanner scanner=new Scanner(System.in);
		for (; i < list.getLength(); i++) {
			if (list.item(i) instanceof Element) {
				Element element = (Element) list.item(i);
				if (element.getAttribute("id").equals(id)) {
					for(int j=0;j<(list.item(i).getChildNodes().getLength()-1)/2;j++){
						String myString=scanner.nextLine();
						list.item(i).getChildNodes().item(2*j+1).setTextContent(myString);
						write(document);
					}
					findAll(document);
					break;
				}
			}
		}
		if(i==list.getLength()){
			System.out.println("无此id");
			findAll(document);
		}
	}

	public static void write(Document document) throws TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(document.getBaseURI()));
	}

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		String path = "src/date0722/depts.xml";
		Document document = XmlUtil.getDocument(path);
		//XmlUtil.findAll(document);
		//XmlUtil.delete(document, "1");
		//XmlUtil.update(document, "6");
		XmlUtil.add(document);
	}
}
