package date0711;

import java.util.Scanner;

/**
 * OrderingUtil类
 * 
 * @author CSH
 * @date 2018年7月11日上午8:29:17
 */
public class OrderingUtil {

	static String[] names = new String[4]; // 保存订餐人名称
	static String[] dishMegs = new String[4]; // 保存菜品名及份数
	static int[] times = new int[4]; // 保存送餐日期
	static String[] addresses = new String[4]; // 保存送餐地址
	static double[] sumPrices = new double[4]; // 保存订单的总金额
	static int[] states = new int[4]; // 保存订单状态： 0：已预订 1：已完成

	static String[] foodNames = { "红烧鱼", "鱼肉丝", "生菜", "鸡蛋汤" };
	static double[] foodPrices = { 38, 20, 10, 12 };
	static int[] praises = { 0, 0, 0, 0 };

	static int myId = 0;

	// 实现菜单切换 ,使用switch语句实现菜单切换
	public static void startMenu() {
		System.out.println("1,我要订餐\n2,查看餐袋\n3,签收订单\n4,删除订单\n5,我要点赞\n6,退出系统");
		System.out.println("********************");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.print("请选择：");
			int n = 0;
			try {
				n = scanner.nextInt();
			} catch (Exception e) {
			}
			switch (n) {
			case 1:
				System.out.println("*******我要订餐*******");
				add();
				back();
				flag = false;
				break;
			case 2:
				System.out.println("*******查看餐袋*******");
				display();
				back();
				flag = false;
				break;
			case 3:
				System.out.println("*******签收订单*******");
				sign();
				back();
				flag = false;
				break;
			case 4:
				System.out.println("*******删除订单*******");
				delete();
				back();
				flag = false;
				break;
			case 5:
				System.out.println("*******我要点赞*******");
				praise();
				back();
				flag = false;
				break;
			case 6:
				System.out.println("*******退出系统*******");
				quit();
				flag = false;
				break;
			default:
				System.out.println("输入数字错误,请重新选择");
				flag = true;
				back();
				break;
			}
		}

	}

	// 遍历系统中已有的订单，并逐条显示输出
	public static void display() {
		System.out.println("序号\t订餐人\t餐品信息\t送餐时间\t送餐地址\t总金额\t订单状态");
		for (int i = 0; i < 4; i++) {
			if (names[i] != null && names[i] != "") {
				System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + times[i] + "点\t"
						+ addresses[i] + "\t" + sumPrices[i] + "\t" + states[i]);
			}
		}
	}

	// 增加一条订单信息，实现我要订餐
	public static void add() {
		showFood();
		System.out.print("请输入订餐人姓名：");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.print("请输入你要点的菜品编号：");
		String id = scanner.next();
		while (true) {
			if (!("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id))) {
				System.out.print("输入错误,请重新输入编号：");
				id = scanner.next();
			} else {
				break;
			}
		}
		System.out.print("请输入你需要的份数(1份-5份)：");
		String sum = scanner.next();
		while (true) {
			if (!("1".equals(sum) || "2".equals(sum) || "3".equals(sum) || "4".equals(sum) || "5".equals(sum))) {
				System.out.print("输入错误,请重新输入份数：");
				sum = scanner.next();
			} else {
				break;
			}
		}
		System.out.print("请输入送餐时间(11点-13点间和18点-20点的整点时间)：");
		String time = scanner.next();
		while (true) {
			if (!("11".equals(time) || "12".equals(time) || "13".equals(time) || "18".equals(time) || "19".equals(time)
					|| "20".equals(time))) {
				System.out.print("输入错误,请重新输入时间：");
				time = scanner.next();
			} else {
				break;
			}
		}
		System.out.print("请输入送餐地址：");
		String address = scanner.next();
		System.out.println("订餐成功");
		String foodName = foodNames[Integer.parseInt(id) - 1];
		System.out.println("你订的是：" + foodName + sum + "份");
		System.out.println("送餐时间：" + time + "点");
		double allFoodPrice = foodPrices[Integer.parseInt(id) - 1] * Integer.parseInt(sum);
		double fee = 0;
		if (allFoodPrice < 50) {
			fee = 5;
		}
		System.out.println("餐费：" + allFoodPrice + "元,送餐费" + fee + "元,共计" + (allFoodPrice + fee) + "元");
		names[myId] = name;
		dishMegs[myId] = foodName + sum + "份";
		times[myId] = Integer.parseInt(time);
		addresses[myId] = address;
		sumPrices[myId] = allFoodPrice + fee;
		states[myId] = 0;
		myId++;
	}

	// 送餐后，将用户签收订单状态修改为“已完成”
	public static void sign() {
		System.out.print("请输入要签收的订单序号(1号-4号)：");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		while (true) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id)) {
				if (correctID(Integer.parseInt(id))) {
					System.out.println("输入错误,该订单已签收");
					System.out.print("请重新输入序号：");
					id = scanner.next();
				} else {
					states[Integer.parseInt(id) - 1] = 1;
					System.out.println("订单签收成功");
					break;
				}

			} else {
				System.out.println("输入错误,该序号不存在");
				System.out.print("请重新输入序号：");
				id = scanner.next();
			}
		}
	}

	// 判断已签收
	public static boolean correctID(int id) {
		if (states[id - 1] == 1) {
			return true;
		}
		return false;
	}

	// 删除“已完成”状态的订单
	public static void delete() {
		System.out.print("请输入要删除的订单序号(1号-4号)：");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		while (true) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id)) {
				if (correctID2(Integer.parseInt(id))) {
					System.out.println("该订单未签收,不能删除");
					System.out.print("请重新输入序号：");
					id = scanner.next();
				} else {
					names[Integer.parseInt(id) - 1] = "";
					dishMegs[Integer.parseInt(id) - 1] = "";
					times[Integer.parseInt(id) - 1] = 0;
					addresses[Integer.parseInt(id) - 1] = "";
					sumPrices[Integer.parseInt(id) - 1] = 0;
					states[Integer.parseInt(id) - 1] = 0;
					System.out.println("订单删除成功");
					break;
				}

			} else {
				System.out.println("输入错误,该序号错误");
				System.out.print("请重新输入序号：");
				id = scanner.next();
			}
		}

	}

	// 判断未签收
	public static boolean correctID2(int id) {
		if (states[id - 1] == 0) {
			return true;
		}
		return false;
	}

	// 显示菜品信息
	public static void showFood() {
		System.out.println("序号\t菜名\t单价\t点赞数");
		for (int i = 0; i < 4; i++) {
			System.out.println((i + 1) + "\t" + foodNames[i] + "\t" + foodPrices[i] + "\t" + praises[i]);
		}
	}

	// 显示菜品序号、菜品名、单价、点赞数提示用户输入要点赞的菜品序号
	public static void praise() {
		System.out.print("请输入要点赞的菜品序号(1号-4号)：");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		while (true) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id)) {

				praises[Integer.parseInt(id) - 1]++;
				System.out.println("点赞成功");
				break;

			} else {
				System.out.println("输入错误,该序号错误");
				System.out.print("请重新输入序号：");
				id = scanner.next();
			}
		}
	}

	// 退出系统
	public static void quit() {
		System.out.println("已退出系统");
	}

	// 返回
	public static void back() {
		System.out.print("输入0返回：");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			String m = scanner.next();
			switch (m) {
			case "0":
				startMenu();
				flag = false;
				break;
			default:
				System.out.print("输入不是0,重新输入：");
				flag = true;
				break;
			}
		}
	}
}
