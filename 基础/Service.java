package date0712;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Service业务类
 * 
 * @author CSH
 * @date 2018年7月11日下午8:55:56
 */
public class Service {

	// 开始进入嗖嗖移动业务大厅
	public void startMobile() throws IOException {
		System.out.println("****************欢迎使用嗖嗖移动业务大厅***************");
		System.out.println("1用户登录，2用户注册，3使用嗖嗖，4话费充值，5资费说明，6退出系统");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.print("请选择：");
			String n = scanner.next();
			switch (n) {
			case "1":
				System.out.println("*******用户登录*******");
				login();
				back();
				flag = false;
				break;
			case "2":
				System.out.println("*******用户注册*******");
				register();
				back();
				flag = false;
				break;
			case "3":
				System.out.println("*******使用嗖嗖*******");
				useSoso();
				back();
				flag = false;
				break;
			case "4":
				System.out.println("*******话费充值*******");
				setMoney();
				back();
				flag = false;
				break;
			case "5":
				System.out.println("*******资费说明*******");
				showFee();
				back();
				flag = false;
				break;
			case "6":
				System.out.println("*******退出系统*******");
				System.out.println("已退出系统,谢谢使用");
				flag = false;
				break;
			default:
				System.out.println("输入数字错误,请重新选择");
				flag = true;
				break;
			}
		}

	}

	// 返回系统菜单
	public void back() throws IOException {
		System.out.print("输入0返回大厅：");
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
				System.out.print("输入不是0,重新输入：");
				flag = true;
				break;
			}
		}
	}

	// 用户登录，
	public void login() throws IOException {
		
		System.out.print("请输入手机卡号：");
		Scanner scanner = new Scanner(System.in);
		String cardNumber = scanner.next();
		while(true){
			if(CardUtil.isExistCard(cardNumber)){
				break;
			}else{
				System.out.print("卡号不存在，请重新输入：");
				cardNumber = scanner.next();
			}
		}
		System.out.print("请输入密码：");
		String password = scanner.next();
		while(true){
			if(CardUtil.isExistCard(cardNumber, password)){
				System.out.println("登录成功");
				break;
			}else {
				System.out.println("登录失败,密码错误");
				System.out.print("请重新输入密码：");
				password = scanner.next();
			}
		}
		intoMobile(cardNumber);
	}

	// 进入移动用户菜单
	public void intoMobile(String cardNumber) throws IOException {
		System.out.println("****嗖嗖移动用户菜单****");
		System.out.println("1.本月账单查询\n2.套餐余量查询\n3.打印消费详单\n4.套餐变更\n5.办理退网\n6.退出账户");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.print("请选择：");
			String n = scanner.next();
			switch (n) {
			case "1":
				System.out.println("*******本月账单查询*******");
				CardUtil.showAmountDetail(cardNumber);
				back2(cardNumber);
				flag = false;
				break;
			case "2":
				System.out.println("*******套餐余量查询*******");
				CardUtil.showRemainDetail(cardNumber);
				back2(cardNumber);
				flag = false;
				break;
			case "3":
				System.out.println("*******打印消费详单*******");
				CardUtil.printConsumInfo(cardNumber);
				back2(cardNumber);
				flag = false;
				break;
			case "4":
				System.out.println("********套餐变更*********");
				CardUtil.changingPack(cardNumber);
				back2(cardNumber);
				flag = false;
				break;
			case "5":
				System.out.println("********办理退网*********");
				CardUtil.delCard(cardNumber);
				flag = false;
				break;
			case "6":
				System.out.println("********退出账户*********");
				System.out.println("已退出账户");
				flag = false;
				break;
			default:
				System.out.println("输入数字错误,请重新选择");
				flag = true;
				break;
			}
		}
	}

	// 返回用户菜单
	private void back2(String cardNumber) throws IOException {
		System.out.print("输入0返回用户菜单：");
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
				System.out.print("输入不是0,重新输入：");
				flag = true;
				break;
			}
		}
	}

	// 用户注册，
	public void register() {
		System.out.println("*******选择卡号*******");
		String[] myNumbers=CardUtil.getNewNumbers(9);
		for (int i = 0; i < myNumbers.length; i++) {
			System.out.print((i + 1) + "." + myNumbers[i] + "  ");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		Scanner scanner = new Scanner(System.in);
		System.out.print("请选择卡号：");
		String id = scanner.next();
		String number;
		while (true) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id) || "5".equals(id) || "6".equals(id)
					|| "7".equals(id) || "8".equals(id) || "9".equals(id)) {
				number = myNumbers[Integer.parseInt(id) - 1];
				break;
			} else {
				System.out.print("输入数字错误，请重新选择卡号：");
				id = scanner.next();
			}
		}
		System.out.print("1.话唠套餐  2.网虫套餐  3.超人套餐  请选择：");
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
				System.out.print("输入数字错误，请重新选择：");
				id = scanner.next();
			}

		}
		System.out.print("请输入姓名：");
		String name = scanner.next();
		System.out.print("请输入密码：");
		String password = scanner.next();
		System.out.print("请输入预存话费金额(50元或100元)：");
		String money = scanner.next();
		while(true){
			if("50".equals(money)||"100".equals(money)){
				break;
			}else{
				System.out.println("输入的预存话费金额错误，不是50元或100元");
				System.out.print("请重新输入金额：");
				money = scanner.next();
			}
		}
		
		MobileCard mobileCard = new MobileCard(number, name, password,Double.parseDouble(money), servicePackage);
		CardUtil.addCard(mobileCard);
		System.out.println("卡号：" + number + "  姓名：" + name + "  余额：" + money + " 元");
		System.out.println(mobileCard.getSerPackage());
	}

	// 使用嗖嗖，
	public void useSoso() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入手机卡号：");
		String card=scanner.next();
		while(true){
			if(CardUtil.isExistCard(card)){
				break;
			}else{
				System.out.print("卡号不存在或着卡号不合法，请重新输入:");
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
					description="问候客户";
					type="通话";
					consumData=30;
					System.out.println("问候客户通话30分钟");
					CallService callService=(CallService) servicePackage;
					callService.call(consumData, CardUtil.getCards().get(card));
					break;
				}else{
					System.out.println("当前套餐不支持此类消费，重新执行此操作");
				}
			}else if(n==2){
				if(servicePackage instanceof TalkPackage||servicePackage instanceof SuperPackage){
					description="通知朋友";
					type="短信";
					consumData=10;
					System.out.println("通知朋友发送10条短信");
					SendService sendService=(SendService) servicePackage;
					sendService.send(consumData, CardUtil.getCards().get(card));
					break;
				}else{
					System.out.println("当前套餐不支持此类消费，重新执行此操作");
				}
			}else{
				if(servicePackage instanceof NetPackage||servicePackage instanceof SuperPackage){
					description="浏览信息";
					type="上网";
					consumData=2;
					System.out.println("浏览信息上网2GB流量");
					NetService netService=(NetService) servicePackage;
					netService.netPlay(consumData, CardUtil.getCards().get(card));
					break;
				}else{
					System.out.println("当前套餐不支持此类消费，重新执行此操作");
				}
			}
		}
		ConsumInfo consumInfo=new ConsumInfo(card, type, consumData);
		Scene scene=new Scene(description, type, consumData);
		CardUtil.addConsumInfo(card,consumInfo);
		
		
		System.out.println("已添加一条消费记录");
	}

	// 话费充值，
	public void setMoney() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("请输入充值卡号：");
		String card=scanner.next();
		while(true){
			if(CardUtil.isExistCard(card)){
				break;
			}else{
				System.out.print("卡号不存在或着卡号不合法，请重新输入:");
				card=scanner.next();
			}
		}
		System.out.print("请输入充值话费金额(50元或100元)：");
		String money = scanner.next();
		while(true){
			if("50".equals(money)||"100".equals(money)){
				break;
			}else{
				System.out.println("输入的充值话费金额错误，不是50元或100元");
				System.out.print("请重新输入金额：");
				money = scanner.next();
			}
		}
		CardUtil.chargeMoney(card,Double.parseDouble(money));
	}

	// 资费说明，
	public void showFee() throws IOException {
		CardUtil.showDescription();
	}
}
