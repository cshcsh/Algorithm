package date0712;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * CardUtil������
 * 
 * @author CSH
 * @date 2018��7��11������8:43:29
 */
public class CardUtil {

	private static Map<String, MobileCard> cards;// ���ƶ��û��б�,key->����,value->������
	private static Map<String, List<ConsumInfo>> consumInfos;// �����Ѽ�¼�б�,key->����,value->�ÿ����������Ѽ�¼list

	public static Map<String, MobileCard> getCards() {
		return cards;
	}

	public static void setCards(Map<String, MobileCard> cards) {
		CardUtil.cards = cards;
	}

	public static Map<String, List<ConsumInfo>> getConsumInfos() {
		return consumInfos;
	}

	public static void setConsumInfos(Map<String, List<ConsumInfo>> consumInfos) {
		CardUtil.consumInfos = consumInfos;
	}

	// ��֤�ÿ��Ƿ�ע�ᣬ������
	public static boolean isExistCard(String number, String passWord) {
		if (number != "" && passWord != "") {
			Set<String> numbers = cards.keySet();
			if (numbers.isEmpty()) {
				return false;
			} else {
				if (numbers.contains(number)) {
					MobileCard mobileCard = cards.get(number);
					if (mobileCard != null) {
						if (passWord.equals(mobileCard.getPassWord())) {
							return true;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}

	// ��֤�ÿ��Ƿ�ע�ᣬ������
	public static boolean isExistCard(String number) {
		if (cards.keySet().contains(number) && number.length() == 11) {
			return true;
		}
		return false;
	}

	// �����������
	public static String[] getNewNumbers(int count) {
		Random random = new Random();
		String[] numbers = new String[count];
		for (int j = 0; j < count; j++) {
			numbers[j] = "";
		}
		String number = "139";
		int i = 0;
		while (i < count) {
			for (int j = 0; j < 8; j++) {
				number = number + random.nextInt(10);
			}
			for (int k = 0; k < count; k++) {
				if (!(isExistCard(number) || numbers[k].equals(number))) {

					numbers[i] = number;
					i++;
				}
			}
		}
		return numbers;

	}

	// ע���¿�
	public static void addCard(MobileCard card) {
		cards.put(card.getCardNumber(), card);
		System.out.println("ע��ɹ�");
	}

	// ��������
	public static void delCard(String number) {
		cards.remove(number);
		System.out.println("����" + number + "���������ɹ�\nллʹ��");
	}

	// �ײ�������ѯ,instanceof�ж�
	public static void showRemainDetail(String number) {
		System.out.print("��Ŀ��ţ�" + number);
		MobileCard mobileCard = cards.get(number);
		double myTalkTime = 0;
		int mySMSCount = 0;
		int myFlow = 0;
		if (cards.get(number).getSerPackage() instanceof TalkPackage) {
			myTalkTime = 500;
			mySMSCount = 30;
			myFlow = 0;
		}
		if (cards.get(number).getSerPackage() instanceof NetPackage) {
			myTalkTime = 0;
			mySMSCount = 0;
			myFlow = 3;
		}
		if (cards.get(number).getSerPackage() instanceof SuperPackage) {
			myTalkTime = 200;
			mySMSCount = 50;
			myFlow = 1;
		}
		double realTalkTime = mobileCard.getRealTalkTime();
		int realSMSCount = mobileCard.getRealSMSCount();
		int realFlow = mobileCard.getRealFlow();
		System.out.println("  �ײ���ʣ�ࣺ" + "\nͨ��ʱ����" + (myTalkTime - realTalkTime) + "����\n����������"
				+ (mySMSCount - realSMSCount) + "����\n����������" + (myFlow - realFlow) + "GB");
	}

	// �����˵���ѯ
	public static void showAmountDetail(String number) {
		System.out.print("��Ŀ��ţ�" + number);
		System.out.println("  �����˵���\n" + "�ײ��ʷѣ�" + cards.get(number).getSerPackage().getPrice() + "Ԫ  ���ѻ��ѣ�"
				+ cards.get(number).getConsumAmount() + "Ԫ  �˻���" + String.format("%.1f", cards.get(number).getMoney())
				+ "Ԫ");
	}

	// ���������Ϣ
	public static void addConsumInfo(String number, ConsumInfo info) {
		if (consumInfos.containsKey(number)) {
			consumInfos.get(number).add(info);
		} else {
			List<ConsumInfo> list = new ArrayList<>();
			list.add(info);
			consumInfos.put(number, list);
		}
	}

	// �ʷ�˵��
	public static void showDescription() throws IOException {
		File file = new File("D:\\�ʷ�˵��.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] b = new byte[1024];
		fileInputStream.read(b);
		System.out.println(new String(b));
	}

	// �ײͱ��
	public static void changingPack(String number) {
		System.out.print("1.�����ײ�  2.�����ײ�  3.�����ײ�  ��ѡ��");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		boolean flag2 = true;
		while (flag2) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id)) {
				double price = 0;
				if ("1".equals(id)) {
					price = 58;
				}
				if ("2".equals(id)) {
					price = 68;
				}
				if ("3".equals(id)) {
					price = 78;
				}
				if (price == cards.get(number).getSerPackage().getPrice()) {
					System.out.println("�Բ��������Ǹ��ײ͵��û������軻�ײ�");
				} else {
					if ("1".equals(id)) {
						cards.get(number).setSerPackage(new TalkPackage());
					}
					if ("2".equals(id)) {
						cards.get(number).setSerPackage(new NetPackage());
					}
					if ("3".equals(id)) {
						cards.get(number).setSerPackage(new SuperPackage());
					}
					System.out.println("�����ײͳɹ�");
				}
				flag2 = false;
			} else {
				System.out.println("�������ִ���������ѡ��");
				id = scanner.next();
				flag2 = true;
			}

		}
	}

	// ��ӡ�����굥
	public static void printConsumInfo(String number) throws IOException {
		String string="";
		String string2="*******" + number + "���Ѽ�¼*******\n���\t����\t����(����/����/GB)\n";
		System.out.print(string2);
		if (consumInfos.get(number) != null) {
			for (int i = 0; i < consumInfos.get(number).size(); i++) {
				string = string+(i + 1) + "\t" + consumInfos.get(number).get(i).getType() + "\t"
						+ consumInfos.get(number).get(i).getConsumData()+"\n";
			}
			System.out.print(string);
			File file = new File("D:\\consumInfo.txt");
			FileOutputStream fileOutputStream = new FileOutputStream(file,true);
			fileOutputStream.write((string2+string).getBytes(), 0, (string2+string).getBytes().length);
			fileOutputStream.flush();
			fileOutputStream.close();
		} else {
			System.out.println("�������˵�");
		}

		System.out.println("��ӡ�ɹ�");
	}

	// ���ѳ�ֵ
	public static void chargeMoney(String number, double money) {
		cards.get(number).setMoney(money + cards.get(number).getMoney());
		System.out.println("��ֵ�ɹ�");
	}
}
