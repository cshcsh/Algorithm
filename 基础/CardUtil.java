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
 * CardUtil工具类
 * 
 * @author CSH
 * @date 2018年7月11日下午8:43:29
 */
public class CardUtil {

	private static Map<String, MobileCard> cards;// 嗖嗖移动用户列表,key->卡号,value->卡对象
	private static Map<String, List<ConsumInfo>> consumInfos;// 卡消费记录列表,key->卡号,value->该卡的所有消费记录list

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

	// 验证该卡是否注册，有密码
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

	// 验证该卡是否注册，无密码
	public static boolean isExistCard(String number) {
		if (cards.keySet().contains(number) && number.length() == 11) {
			return true;
		}
		return false;
	}

	// 生成随机卡号
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

	// 注册新卡
	public static void addCard(MobileCard card) {
		cards.put(card.getCardNumber(), card);
		System.out.println("注册成功");
	}

	// 办理退网
	public static void delCard(String number) {
		cards.remove(number);
		System.out.println("卡号" + number + "办理退网成功\n谢谢使用");
	}

	// 套餐余量查询,instanceof判断
	public static void showRemainDetail(String number) {
		System.out.print("你的卡号：" + number);
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
		System.out.println("  套餐内剩余：" + "\n通话时长：" + (myTalkTime - realTalkTime) + "分钟\n短信条数："
				+ (mySMSCount - realSMSCount) + "条数\n上网流量：" + (myFlow - realFlow) + "GB");
	}

	// 本月账单查询
	public static void showAmountDetail(String number) {
		System.out.print("你的卡号：" + number);
		System.out.println("  当月账单：\n" + "套餐资费：" + cards.get(number).getSerPackage().getPrice() + "元  消费话费："
				+ cards.get(number).getConsumAmount() + "元  账户余额：" + String.format("%.1f", cards.get(number).getMoney())
				+ "元");
	}

	// 添加消费信息
	public static void addConsumInfo(String number, ConsumInfo info) {
		if (consumInfos.containsKey(number)) {
			consumInfos.get(number).add(info);
		} else {
			List<ConsumInfo> list = new ArrayList<>();
			list.add(info);
			consumInfos.put(number, list);
		}
	}

	// 资费说明
	public static void showDescription() throws IOException {
		File file = new File("D:\\资费说明.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		byte[] b = new byte[1024];
		fileInputStream.read(b);
		System.out.println(new String(b));
	}

	// 套餐变更
	public static void changingPack(String number) {
		System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐  请选择：");
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
					System.out.println("对不起，你已是该套餐的用户，无需换套餐");
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
					System.out.println("更改套餐成功");
				}
				flag2 = false;
			} else {
				System.out.println("输入数字错误，请重新选择：");
				id = scanner.next();
				flag2 = true;
			}

		}
	}

	// 打印消费详单
	public static void printConsumInfo(String number) throws IOException {
		String string="";
		String string2="*******" + number + "消费记录*******\n序号\t类型\t数据(分钟/条数/GB)\n";
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
			System.out.println("无消费账单");
		}

		System.out.println("打印成功");
	}

	// 话费充值
	public static void chargeMoney(String number, double money) {
		cards.get(number).setMoney(money + cards.get(number).getMoney());
		System.out.println("充值成功");
	}
}
