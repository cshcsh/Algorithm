package date0709;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ˫ɫ��
 * ����˫ɫ�򣬹���˫ɫ���ж��н�
 * @author CSH
 * @date 2018��7��10������7:12:53
 */
public class RedBlue {

	private int[] trueRedBlue={5,8,13,16,22,31,10};//�н�����
	private static int[] redBlue=new int[7];//���˫ɫ�����
	
	//�ж��ظ�
	public boolean isOver(int[] red,int n){
		boolean flag=true;
		for(int i=0;i<red.length;i++){
			if(n==red[i]){
				flag=false;
				break;
			}
		}
		return flag;
	}
	
	//����˫ɫ��
	public void getRedBlue(){
		int[] red=new int[6];
		Scanner scanner=new Scanner(System.in);
		int i=1;
		while(i<=6){
			System.out.print("�������� "+i+" �����룺");
			int n=scanner.nextInt();
			if(isOver(red,n)&&n>=1&&n<=33){
				red[i-1]=n;
				i++;
			}else{
				System.out.println("����������,��������");
			}
		}
		int blue=0;
		while(true){
			System.out.print("����������룺");
			int b=scanner.nextInt();
			if(b>=1&&b<=16){
				blue=b;
				break;
			}
		}
		Arrays.sort(red);
		for(int j=0;j<redBlue.length-1;j++){
			redBlue[j]=red[j];
		}
		redBlue[6]=blue;
	}
	
	//����˫ɫ��
	public void buyRedBlue(){
		System.out.print("������룺");
		for(int i=0;i<redBlue.length;i++){
			System.out.print(redBlue[i]+" ");
		}
		System.out.println();
	}
	
	//�ж��н�
	public void price(int[] redBlue){
		boolean flag = false;
		if (redBlue[6] == trueRedBlue[6]) {
			flag = true;
		}
		int count = 0;
		for (int i = 0; i < redBlue.length - 1; i++) {
			for (int j = 0; j < trueRedBlue.length - 1; j++) {
				if (redBlue[i] == trueRedBlue[j]) {
					count++;
					break;
				}
			}
		}
		if (flag && count == 6) {
			System.out.println("һ�Ƚ�");
		} else if (count == 6) {
			System.out.println("���Ƚ�");
		} else if (flag && count == 5) {
			System.out.println("���Ƚ�");
		} else if (count == 5 || (flag && count == 4)) {
			System.out.println("�ĵȽ�");
		} else if (count == 4 || (flag && count == 3)) {
			System.out.println("��Ƚ�");
		} else if (flag) {
			System.out.println("���Ƚ�");
		} else {
			System.out.println("û���н�");
		}
	}
	
	public static void main(String[] args) {
		
		RedBlue r=new RedBlue();
		r.getRedBlue();
		r.buyRedBlue();
		r.price(redBlue);
	}
}
