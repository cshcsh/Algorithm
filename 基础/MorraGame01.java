package date0709;

import java.util.Random;
import java.util.Scanner;

class User {
	private String userName;
	private int score;

	public User(String userName) {
		super();
		this.userName = userName;
		this.score = 0;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// 出拳
	public int showFist() {
		System.out.print("请出拳：1剪刀,2石头,3布(输入相应的数字):\n");
		System.out.print("你出拳：");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		switch (n) {
		case 1:
			System.out.print(" 剪刀");
			break;
		case 2:
			System.out.print(" 石头");
			break;
		case 3:
			System.out.print(" 布");
			break;
		default:
			System.out.print(" 错误");
			n = -1;
			break;
		}
		return n;
	}
}

class Computer {
	private String computerName;
	private int score;

	public Computer(String computerName) {
		super();
		this.computerName = computerName;
		this.score = 0;
	}

	public String getComputerName() {
		return computerName;
	}

	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// 出拳
	public int showFist() {
		System.out.print("\n" + this.getComputerName() + "出拳：");
		int n = new Random().nextInt(3) + 1;
		switch (n) {
		case 1:
			System.out.println("剪刀");
			break;
		case 2:
			System.out.println("石头");
			break;
		case 3:
			System.out.println("布");
			break;
		default:
			System.out.println("错误");
			break;
		}
		return n;
	}
}

class Game {
	private User user;
	private Computer computer;
	private int count = 0;

	Scanner scanner = new Scanner(System.in);

	// 初始化比赛
	public void initialGame() {
		System.out.print("---------------欢迎进入游戏世界------------------\n");
		System.out.print("---------------------------------------------\n");
		System.out.print("------------------猜拳,开始--------------------\n");
		System.out.print("---------------------------------------------\n");
		System.out.print("出拳规则:1剪刀,2石头,3布\n");
		System.out.print("请选择对方角色(1孙权,2刘备,3曹操):");

		boolean flag = true;
		String role = null;
		while (flag) {
			int n = scanner.nextInt();
			switch (n) {
			case 1:
				role = "孙权";
				flag = false;
				break;
			case 2:
				role = "刘备";
				flag = false;
				break;
			case 3:
				role = "曹操";
				flag = false;
				break;
			default:
				System.out.println("选择数字错误,请重新选择数字1,2,3");
				flag = true;
				break;
			}
		}
		System.out.print("你选择了" + role + "对战");
		computer = new Computer(role);
		System.out.print("\n请输入你的姓名:");
		String name = scanner.next();// 注意空字符串
		user = new User(name);
		System.out.println(name + " VS " + role);
		// startGame();
	}

	// 开始比赛
	public void startGame() {

		while (true) {
			System.out.print("要开始吗？(y/n):");
			String string = scanner.next();
			if ("y".equals(string)) {
				int userScore = user.showFist();
				int computerScore = computer.showFist();
				if (userScore == computerScore && userScore != -1) {
					System.out.println("和局，真衰，嘿嘿，等着瞧");
					count = count + 1;
				} else if ((userScore - computerScore == 1 || computerScore - userScore == 2) && userScore != -1) {
					System.out.println("恭喜，你赢了");
					count = count + 1;
					user.setScore(user.getScore() + 1);
				} else if ((userScore - computerScore == -1 || computerScore - userScore == -2) &&userScore != -1) {
					System.out.println("呵呵，笨蛋，下次加油");
					count = count + 1;
					computer.setScore(computer.getScore() + 1);
				}

			} else if ("n".equals(string)) {
				System.out.println("游戏未开始");
				break;
			} else {
				System.out.println("输入错误");
			}
		}

	}

	// 显示结果
	public void showResult() {
		System.out.println(user.getUserName() + " VS " + computer.getComputerName());
		System.out.println("对战次数:" + count);
		System.out.println("姓名\t得分");
		System.out.println(user.getUserName() + "\t" + user.getScore());
		System.out.println(computer.getComputerName() + "\t" + computer.getScore());
		if (user.getScore() > computer.getScore()) {
			System.out.println("你赢了");
		} else if (user.getScore() < computer.getScore()) {
			System.out.println("你输了");
		} else {
			System.out.println("平局");
		}
	}
}

/**
 * 猜拳比赛1.0版本
 * 
 * @author CSH
 * @date 2018年7月9日下午8:30:46
 */
public class MorraGame01 {

	public static void main(String[] args) {

		Game game = new Game();
		game.initialGame();
		game.startGame();
		game.showResult();
	}

}
