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

	// ��ȭ
	public int showFist() {
		System.out.print("���ȭ��1����,2ʯͷ,3��(������Ӧ������):\n");
		System.out.print("���ȭ��");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		switch (n) {
		case 1:
			System.out.print(" ����");
			break;
		case 2:
			System.out.print(" ʯͷ");
			break;
		case 3:
			System.out.print(" ��");
			break;
		default:
			System.out.print(" ����");
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

	// ��ȭ
	public int showFist() {
		System.out.print("\n" + this.getComputerName() + "��ȭ��");
		int n = new Random().nextInt(3) + 1;
		switch (n) {
		case 1:
			System.out.println("����");
			break;
		case 2:
			System.out.println("ʯͷ");
			break;
		case 3:
			System.out.println("��");
			break;
		default:
			System.out.println("����");
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

	// ��ʼ������
	public void initialGame() {
		System.out.print("---------------��ӭ������Ϸ����------------------\n");
		System.out.print("---------------------------------------------\n");
		System.out.print("------------------��ȭ,��ʼ--------------------\n");
		System.out.print("---------------------------------------------\n");
		System.out.print("��ȭ����:1����,2ʯͷ,3��\n");
		System.out.print("��ѡ��Է���ɫ(1��Ȩ,2����,3�ܲ�):");

		boolean flag = true;
		String role = null;
		while (flag) {
			int n = scanner.nextInt();
			switch (n) {
			case 1:
				role = "��Ȩ";
				flag = false;
				break;
			case 2:
				role = "����";
				flag = false;
				break;
			case 3:
				role = "�ܲ�";
				flag = false;
				break;
			default:
				System.out.println("ѡ�����ִ���,������ѡ������1,2,3");
				flag = true;
				break;
			}
		}
		System.out.print("��ѡ����" + role + "��ս");
		computer = new Computer(role);
		System.out.print("\n�������������:");
		String name = scanner.next();// ע����ַ���
		user = new User(name);
		System.out.println(name + " VS " + role);
		// startGame();
	}

	// ��ʼ����
	public void startGame() {

		while (true) {
			System.out.print("Ҫ��ʼ��(y/n):");
			String string = scanner.next();
			if ("y".equals(string)) {
				int userScore = user.showFist();
				int computerScore = computer.showFist();
				if (userScore == computerScore && userScore != -1) {
					System.out.println("�;֣���˥���ٺ٣�������");
					count = count + 1;
				} else if ((userScore - computerScore == 1 || computerScore - userScore == 2) && userScore != -1) {
					System.out.println("��ϲ����Ӯ��");
					count = count + 1;
					user.setScore(user.getScore() + 1);
				} else if ((userScore - computerScore == -1 || computerScore - userScore == -2) &&userScore != -1) {
					System.out.println("�Ǻǣ��������´μ���");
					count = count + 1;
					computer.setScore(computer.getScore() + 1);
				}

			} else if ("n".equals(string)) {
				System.out.println("��Ϸδ��ʼ");
				break;
			} else {
				System.out.println("�������");
			}
		}

	}

	// ��ʾ���
	public void showResult() {
		System.out.println(user.getUserName() + " VS " + computer.getComputerName());
		System.out.println("��ս����:" + count);
		System.out.println("����\t�÷�");
		System.out.println(user.getUserName() + "\t" + user.getScore());
		System.out.println(computer.getComputerName() + "\t" + computer.getScore());
		if (user.getScore() > computer.getScore()) {
			System.out.println("��Ӯ��");
		} else if (user.getScore() < computer.getScore()) {
			System.out.println("������");
		} else {
			System.out.println("ƽ��");
		}
	}
}

/**
 * ��ȭ����1.0�汾
 * 
 * @author CSH
 * @date 2018��7��9������8:30:46
 */
public class MorraGame01 {

	public static void main(String[] args) {

		Game game = new Game();
		game.initialGame();
		game.startGame();
		game.showResult();
	}

}
