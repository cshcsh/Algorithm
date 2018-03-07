package date0711;

import java.util.Scanner;

/**
 * OrderingUtil��
 * 
 * @author CSH
 * @date 2018��7��11������8:29:17
 */
public class OrderingUtil {

	static String[] names = new String[4]; // ���涩��������
	static String[] dishMegs = new String[4]; // �����Ʒ��������
	static int[] times = new int[4]; // �����Ͳ�����
	static String[] addresses = new String[4]; // �����Ͳ͵�ַ
	static double[] sumPrices = new double[4]; // ���涩�����ܽ��
	static int[] states = new int[4]; // ���涩��״̬�� 0����Ԥ�� 1�������

	static String[] foodNames = { "������", "����˿", "����", "������" };
	static double[] foodPrices = { 38, 20, 10, 12 };
	static int[] praises = { 0, 0, 0, 0 };

	static int myId = 0;

	// ʵ�ֲ˵��л� ,ʹ��switch���ʵ�ֲ˵��л�
	public static void startMenu() {
		System.out.println("1,��Ҫ����\n2,�鿴�ʹ�\n3,ǩ�ն���\n4,ɾ������\n5,��Ҫ����\n6,�˳�ϵͳ");
		System.out.println("********************");
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.print("��ѡ��");
			int n = 0;
			try {
				n = scanner.nextInt();
			} catch (Exception e) {
			}
			switch (n) {
			case 1:
				System.out.println("*******��Ҫ����*******");
				add();
				back();
				flag = false;
				break;
			case 2:
				System.out.println("*******�鿴�ʹ�*******");
				display();
				back();
				flag = false;
				break;
			case 3:
				System.out.println("*******ǩ�ն���*******");
				sign();
				back();
				flag = false;
				break;
			case 4:
				System.out.println("*******ɾ������*******");
				delete();
				back();
				flag = false;
				break;
			case 5:
				System.out.println("*******��Ҫ����*******");
				praise();
				back();
				flag = false;
				break;
			case 6:
				System.out.println("*******�˳�ϵͳ*******");
				quit();
				flag = false;
				break;
			default:
				System.out.println("�������ִ���,������ѡ��");
				flag = true;
				back();
				break;
			}
		}

	}

	// ����ϵͳ�����еĶ�������������ʾ���
	public static void display() {
		System.out.println("���\t������\t��Ʒ��Ϣ\t�Ͳ�ʱ��\t�Ͳ͵�ַ\t�ܽ��\t����״̬");
		for (int i = 0; i < 4; i++) {
			if (names[i] != null && names[i] != "") {
				System.out.println((i + 1) + "\t" + names[i] + "\t" + dishMegs[i] + "\t" + times[i] + "��\t"
						+ addresses[i] + "\t" + sumPrices[i] + "\t" + states[i]);
			}
		}
	}

	// ����һ��������Ϣ��ʵ����Ҫ����
	public static void add() {
		showFood();
		System.out.print("�����붩����������");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.next();
		System.out.print("��������Ҫ��Ĳ�Ʒ��ţ�");
		String id = scanner.next();
		while (true) {
			if (!("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id))) {
				System.out.print("�������,�����������ţ�");
				id = scanner.next();
			} else {
				break;
			}
		}
		System.out.print("����������Ҫ�ķ���(1��-5��)��");
		String sum = scanner.next();
		while (true) {
			if (!("1".equals(sum) || "2".equals(sum) || "3".equals(sum) || "4".equals(sum) || "5".equals(sum))) {
				System.out.print("�������,���������������");
				sum = scanner.next();
			} else {
				break;
			}
		}
		System.out.print("�������Ͳ�ʱ��(11��-13����18��-20�������ʱ��)��");
		String time = scanner.next();
		while (true) {
			if (!("11".equals(time) || "12".equals(time) || "13".equals(time) || "18".equals(time) || "19".equals(time)
					|| "20".equals(time))) {
				System.out.print("�������,����������ʱ�䣺");
				time = scanner.next();
			} else {
				break;
			}
		}
		System.out.print("�������Ͳ͵�ַ��");
		String address = scanner.next();
		System.out.println("���ͳɹ�");
		String foodName = foodNames[Integer.parseInt(id) - 1];
		System.out.println("�㶩���ǣ�" + foodName + sum + "��");
		System.out.println("�Ͳ�ʱ�䣺" + time + "��");
		double allFoodPrice = foodPrices[Integer.parseInt(id) - 1] * Integer.parseInt(sum);
		double fee = 0;
		if (allFoodPrice < 50) {
			fee = 5;
		}
		System.out.println("�ͷѣ�" + allFoodPrice + "Ԫ,�Ͳͷ�" + fee + "Ԫ,����" + (allFoodPrice + fee) + "Ԫ");
		names[myId] = name;
		dishMegs[myId] = foodName + sum + "��";
		times[myId] = Integer.parseInt(time);
		addresses[myId] = address;
		sumPrices[myId] = allFoodPrice + fee;
		states[myId] = 0;
		myId++;
	}

	// �Ͳͺ󣬽��û�ǩ�ն���״̬�޸�Ϊ������ɡ�
	public static void sign() {
		System.out.print("������Ҫǩ�յĶ������(1��-4��)��");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		while (true) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id)) {
				if (correctID(Integer.parseInt(id))) {
					System.out.println("�������,�ö�����ǩ��");
					System.out.print("������������ţ�");
					id = scanner.next();
				} else {
					states[Integer.parseInt(id) - 1] = 1;
					System.out.println("����ǩ�ճɹ�");
					break;
				}

			} else {
				System.out.println("�������,����Ų�����");
				System.out.print("������������ţ�");
				id = scanner.next();
			}
		}
	}

	// �ж���ǩ��
	public static boolean correctID(int id) {
		if (states[id - 1] == 1) {
			return true;
		}
		return false;
	}

	// ɾ��������ɡ�״̬�Ķ���
	public static void delete() {
		System.out.print("������Ҫɾ���Ķ������(1��-4��)��");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		while (true) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id)) {
				if (correctID2(Integer.parseInt(id))) {
					System.out.println("�ö���δǩ��,����ɾ��");
					System.out.print("������������ţ�");
					id = scanner.next();
				} else {
					names[Integer.parseInt(id) - 1] = "";
					dishMegs[Integer.parseInt(id) - 1] = "";
					times[Integer.parseInt(id) - 1] = 0;
					addresses[Integer.parseInt(id) - 1] = "";
					sumPrices[Integer.parseInt(id) - 1] = 0;
					states[Integer.parseInt(id) - 1] = 0;
					System.out.println("����ɾ���ɹ�");
					break;
				}

			} else {
				System.out.println("�������,����Ŵ���");
				System.out.print("������������ţ�");
				id = scanner.next();
			}
		}

	}

	// �ж�δǩ��
	public static boolean correctID2(int id) {
		if (states[id - 1] == 0) {
			return true;
		}
		return false;
	}

	// ��ʾ��Ʒ��Ϣ
	public static void showFood() {
		System.out.println("���\t����\t����\t������");
		for (int i = 0; i < 4; i++) {
			System.out.println((i + 1) + "\t" + foodNames[i] + "\t" + foodPrices[i] + "\t" + praises[i]);
		}
	}

	// ��ʾ��Ʒ��š���Ʒ�������ۡ���������ʾ�û�����Ҫ���޵Ĳ�Ʒ���
	public static void praise() {
		System.out.print("������Ҫ���޵Ĳ�Ʒ���(1��-4��)��");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		while (true) {
			if ("1".equals(id) || "2".equals(id) || "3".equals(id) || "4".equals(id)) {

				praises[Integer.parseInt(id) - 1]++;
				System.out.println("���޳ɹ�");
				break;

			} else {
				System.out.println("�������,����Ŵ���");
				System.out.print("������������ţ�");
				id = scanner.next();
			}
		}
	}

	// �˳�ϵͳ
	public static void quit() {
		System.out.println("���˳�ϵͳ");
	}

	// ����
	public static void back() {
		System.out.print("����0���أ�");
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
				System.out.print("���벻��0,�������룺");
				flag = true;
				break;
			}
		}
	}
}
