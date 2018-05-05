package date0722;

import java.io.IOException;
import java.util.Scanner;

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
import org.xml.sax.SAXException;

/**
 * XML项目
 * 
 * @author CSH
 * @date 2018年7月22日下午7:42:19
 */
public class MDE {

	private String path1 = "src/date0722/managers.xml";
	private String path2 = "src/date0722/depts.xml";
	private String path3 = "src/date0722/emps.xml";
	

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		MDE mde = new MDE();
		mde.login();
	}

	// 用户登录，
	public void login() throws ParserConfigurationException, SAXException, IOException, TransformerException {

		DocumentBuilderFactory facory = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = facory.newDocumentBuilder();
		Document document = db.parse(path1);
		Element element = (Element) document.getElementsByTagName("account").item(0);
		Element element2 = (Element) document.getElementsByTagName("password").item(0);
		String account = element.getTextContent();
		String password = element2.getTextContent();
		System.out.println("输入账户：");
		Scanner scanner = new Scanner(System.in);
		String account2 = scanner.nextLine();
		System.out.println("输入密码：");
		String password2 = scanner.nextLine();
		while (true) {
			if (account2.equals(account) && password2.equals(password)) {
				System.out.println("登录成功");
				break;
			} else {
				System.out.println("账户或密码错误,请重新输入");
				System.out.println("输入账户：");
				account2 = scanner.nextLine();
				System.out.println("输入密码：");
				password2 = scanner.nextLine();
			}
		}
		menu();
	}

	// 菜单选择
	public void menu() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		System.out.println("1: 部门模块 、 2：管理员模块  3：员工模块");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		while (true) {
			if (string.equals("1")) {
				dept();
				break;
			} else if (string.equals("2")) {
				manager();
				break;
			} else if (string.equals("3")) {
				emp();
				break;
			} else {
				System.out.println("输入错误,请重新输入");
				string = scanner.nextLine();
			}

		}
	}

	public void emp() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		System.out.println("1添加,2修改,3查询,4删除");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Document document=XmlUtil.getDocument(path3);
		while (true) {
			if (string.equals("1")) {
				XmlUtil.add(document);
				break;
			} else if (string.equals("2")) {
				String id=scanner.nextLine();
				XmlUtil.update(document, id);
				break;
			} else if (string.equals("3")) {
				XmlUtil.findAll(document);
				break;
			}else if (string.equals("4")) {
				String id2=scanner.nextLine();
				XmlUtil.delete(document, id2);
				break;
			} else {
				System.out.println("输入错误,请重新输入");
				string = scanner.nextLine();
			}

		}
	}

	public void manager() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		System.out.println("1添加,2修改,3查询,4删除");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Document document=XmlUtil.getDocument(path1);
		while (true) {
			if (string.equals("1")) {
				XmlUtil.add(document);
				break;
			} else if (string.equals("2")) {
				String id=scanner.nextLine();
				XmlUtil.update(document, id);
				break;
			} else if (string.equals("3")) {
				XmlUtil.findAll(document);
				break;
			}else if (string.equals("4")) {
				String id2=scanner.nextLine();
				XmlUtil.delete(document, id2);
				break;
			} else {
				System.out.println("输入错误,请重新输入");
				string = scanner.nextLine();
			}

		}
	}

	public void dept() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		System.out.println("1添加,2修改,3查询,4删除");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Document document=XmlUtil.getDocument(path2);
		while (true) {
			if (string.equals("1")) {
				XmlUtil.add(document);
				dept();
				break;
			} else if (string.equals("2")) {
				String id=scanner.nextLine();
				XmlUtil.update(document, id);
				break;
			} else if (string.equals("3")) {
				XmlUtil.findAll(document);
				break;
			}else if (string.equals("4")) {
				String id2=scanner.nextLine();
				XmlUtil.delete(document, id2);
				break;
			} else {
				System.out.println("输入错误,请重新输入");
				string = scanner.nextLine();
			}

		}
	}

}
