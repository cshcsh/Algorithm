package date0712;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Serviceҵ����
 * 
 * @author CSH
 * @date 2018��7��11������8:55:56
 */
public class Service {

	// ��ʼ�������ƶ�ҵ�����
	public void startMobile() throws IOException {
		System.out.println("****************��ӭʹ�����ƶ�ҵ�����***************");
		System.out.println("1�û���¼��2�û�ע�ᣬ3ʹ���ಣ�4���ѳ�ֵ��5�ʷ�˵����6�˳�ϵͳ");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.print("��ѡ��");
			String n = scanner.next();
			switch (n) {
			case "1":
				System.out.println("*******�û���¼*******");
				login();
				back();
				flag = false;
				break;
			case "2":
				System.out.println("*******�û�ע��*******");
				register();
				back();
				flag = false;
				break;
			case "3":
				System.out.println("*******ʹ����*******");
				useSoso();
				back();
				flag = false;
				break;
			case "4":
				System.out.println("*******���ѳ�ֵ*******");
				setMoney();
				back();
				flag = false;
				break;
			case "5":
				System.out.println("*******�ʷ�˵��*******");
				showFee();
				back();
				flag = false;
				break;
			case "6":
				System.out.println("*******�˳�ϵͳ*******");
				System.out.println("���˳�ϵͳ,ллʹ��");
				flag = false;
				break;
			default:
				System.out.println("�������ִ���,������ѡ��");
				flag = true;
				break;
			}
		}

	}

	// ����ϵͳ�˵�
	public void back() throws IOException {
		System.out.print("����0���ش�����");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			String m = scanner.next();
			switch (m) {
			case "0":
				startMobile();
				flag = false;
				break;
			default:
				System.out.print("���벻��0,�������룺");
				flag = true;
				break;
			}
		}
	}

	// �û���¼��
	public void login() throws IOException {
		
		System.out.print("�������ֻ����ţ�");
		Scanner scanner = new Scanner(System.in);
		String cardNumber = scanner.next();
		while(true){
			if(CardUtil.isExistCard(cardNumber)){
				break;
			}else{
				System.out.print("���Ų����ڣ����������룺");
				cardNumber = scanner.next();
			}
		}
		System.out.print("���������룺");
		String password = scanner.next();
		while(true){
			if(CardUtil.isExistCard(cardNumber, password)){
				System.out.println("��¼�ɹ�");
				break;
			}else {
				System.out.println("��¼ʧ��,�������");
				System.out.print("�������������룺");
				password = scanner.next();
			}
		}
		intoMobile(cardNumber);
	}

	// �����ƶ��û��˵�
	public void intoMobile(String cardNumber) throws IOException {
		System.out.println("****���ƶ��û��˵�****");
		System.out.println("1.�����˵���ѯ\n2.�ײ�������ѯ\n3.��ӡ�����굥\n4.�ײͱ��\n5.��������\n6.�˳��˻�");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.print("��ѡ��");
			String n = scanner.next();
			switch (n) {
			case "1":
				System.out.println("*******�����˵���ѯ*******");
				CardUtil.showAmountDetail(cardNumber);
				back2(cardNumber);
				flag = false;
				break;
			case "2":
				System.out.println("*******�ײ�������ѯ*******");
				CardUtil.showRemainDetail(cardNumber);
				back2(cardNumber);
				flag = false;
				break;
			case "3":
				System.out.println("*******��ӡ�����굥*******");
				CardUtil.printConsumInfo(cardNumber);
				back2(cardNumber);
				flag = false;
				break;
			case "4":
				System.out.println("********�ײͱ��*********");
				CardUtil.changingPack(cardNumber);
				back2(cardNumber);
				flag = false;
				break;
			case "5":
				System.out.println("********��������*********");
				CardUtil.delCard(cardNumber);
				flag = false;
				break;
			case "6":
				System.out.println("********�˳��˻�*********");
				System.out.println("���˳��˻�");
				flag = false;
				break;
			default:
				System.out.println("�������ִ���,������ѡ��");
				flag = true;
				break;
			}
		}
	}

	// �����û��˵�
	private void back2(String cardNumber) throws IOException {
		System.out.print("����0�����û��˵���");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			String m = scanner.next();
			switch (m) {
			case "0":
				intoMobile(cardNumber);
				flag = false;
				break;
			default:
				System.out.print("���벻��0,�������룺");
				flag = true;
				break;
			}
		}
	}

	// �û�ע�ᣬ
	public void register() {
		System.out.println("*******ѡ�񿨺�*******");
		String[] myNumbers=CardUtil.getNewNumbers(9);
		for (int i = 0; i < myNumbers.length; i++) {
			System.out.print((i + 1) + "." + myNumbers[i] + "  ");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("��ѡ�񿨺ţ�");
		String id = scanner.next();
		String number;
		while (true) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id) || "5".equals(id) || "6".equals(id)
					|| "7".equals(id) || "8".equals(id) || "9".equals(id)) {
				number = myNumbers[Integer.parseInt(id) - 1];
				break;
			} else {
				System.out.print("�������ִ���������ѡ�񿨺ţ�");
				id = scanner.next();
			}
		}
		System.out.print("1.�����ײ�  2.�����ײ�  3.�����ײ�  ��ѡ��");
		id = scanner.next();
		ServicePackage servicePackage;
		while (true) {
			if ("1".equals(id)) {
				servicePackage = new TalkPackage();
				break;
			} else if ("2".equals(id)) {
				servicePackage = new NetPackage();
				break;
			} else if ("3".equals(id)) {
				servicePackage = new SuperPackage();
				break;
			} else {
				System.out.print("�������ִ���������ѡ��");
				id = scanner.next();
			}

		}
		System.out.print("������������");
		String name = scanner.next();
		System.out.print("���������룺");
		String password = scanner.next();
		System.out.print("������Ԥ�滰�ѽ��(50Ԫ��100Ԫ)��");
		String money = scanner.next();
		while(true){
			if("50".equals(money)||"100".equals(money)){
				break;
			}else{
				System.out.println("�����Ԥ�滰�ѽ����󣬲���50Ԫ��100Ԫ");
				System.out.print("�����������");
				money = scanner.next();
			}
		}
		
		MobileCard mobileCard = new MobileCard(number, name, password,Double.parseDouble(money), servicePackage);
		CardUtil.addCard(mobileCard);
		System.out.println("���ţ�" + number + "  ������" + name + "  ��" + money + " Ԫ");
		System.out.println(mobileCard.getSerPackage());
	}

	// ʹ���ಣ�
	public void useSoso() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("�������ֻ����ţ�");
		String card=scanner.next();
		while(true){
			if(CardUtil.isExistCard(card)){
				break;
			}else{
				System.out.print("���Ų����ڻ��ſ��Ų��Ϸ�������������:");
				card=scanner.next();
			}
		}
		Random random=new Random();
		ServicePackage servicePackage=CardUtil.getCards().get(card).getSerPackage();
		String description="";
		String type="";
		int consumData=0;
		while(true){
			int n=random.nextInt(3)+1;
			if(n==1){
				if(servicePackage instanceof TalkPackage||servicePackage instanceof SuperPackage){
					description="�ʺ�ͻ�";
					type="ͨ��";
					consumData=30;
					System.out.println("�ʺ�ͻ�ͨ��30����");
					CallService callService=(CallService) servicePackage;
					callService.call(consumData, CardUtil.getCards().get(card));
					break;
				}else{
					System.out.println("��ǰ�ײͲ�֧�ִ������ѣ�����ִ�д˲���");
				}
			}else if(n==2){
				if(servicePackage instanceof TalkPackage||servicePackage instanceof SuperPackage){
					description="֪ͨ����";
					type="����";
					consumData=10;
					System.out.println("֪ͨ���ѷ���10������");
					SendService sendService=(SendService) servicePackage;
					sendService.send(consumData, CardUtil.getCards().get(card));
					break;
				}else{
					System.out.println("��ǰ�ײͲ�֧�ִ������ѣ�����ִ�д˲���");
				}
			}else{
				if(servicePackage instanceof NetPackage||servicePackage instanceof SuperPackage){
					description="�����Ϣ";
					type="����";
					consumData=2;
					System.out.println("�����Ϣ����2GB����");
					NetService netService=(NetService) servicePackage;
					netService.netPlay(consumData, CardUtil.getCards().get(card));
					break;
				}else{
					System.out.println("��ǰ�ײͲ�֧�ִ������ѣ�����ִ�д˲���");
				}
			}
		}
		ConsumInfo consumInfo=new ConsumInfo(card, type, consumData);
		Scene scene=new Scene(description, type, consumData);
		CardUtil.addConsumInfo(card,consumInfo);
		
		
		System.out.println("�����һ�����Ѽ�¼");
	}

	// ���ѳ�ֵ��
	public void setMoney() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("�������ֵ���ţ�");
		String card=scanner.next();
		while(true){
			if(CardUtil.isExistCard(card)){
				break;
			}else{
				System.out.print("���Ų����ڻ��ſ��Ų��Ϸ�������������:");
				card=scanner.next();
			}
		}
		System.out.print("�������ֵ���ѽ��(50Ԫ��100Ԫ)��");
		String money = scanner.next();
		while(true){
			if("50".equals(money)||"100".equals(money)){
				break;
			}else{
				System.out.println("����ĳ�ֵ���ѽ����󣬲���50Ԫ��100Ԫ");
				System.out.print("�����������");
				money = scanner.next();
			}
		}
		CardUtil.chargeMoney(card,Double.parseDouble(money));
	}

	// �ʷ�˵����
	public void showFee() throws IOException {
		CardUtil.showDescription();
	}
}
