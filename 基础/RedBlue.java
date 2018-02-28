package date0709;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 双色球
 * 生成双色球，购买双色球，判断中奖
 * @author CSH
 * @date 2018年7月10日下午7:12:53
 */
public class RedBlue {

	private int[] trueRedBlue={5,8,13,16,22,31,10};//中奖号码
	private static int[] redBlue=new int[7];//存放双色球号码
	
	//判断重复
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
	
	//输入双色球
	public void getRedBlue(){
		int[] red=new int[6];
		Scanner scanner=new Scanner(System.in);
		int i=1;
		while(i<=6){
			System.out.print("输入红球第 "+i+" 个号码：");
			int n=scanner.nextInt();
			if(isOver(red,n)&&n>=1&&n<=33){
				red[i-1]=n;
				i++;
			}else{
				System.out.println("输入号码错误,重新输入");
			}
		}
		int blue=0;
		while(true){
			System.out.print("输入蓝球号码：");
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
	
	//购买双色球
	public void buyRedBlue(){
		System.out.print("购买号码：");
		for(int i=0;i<redBlue.length;i++){
			System.out.print(redBlue[i]+" ");
		}
		System.out.println();
	}
	
	//判断中奖
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
			System.out.println("一等奖");
		} else if (count == 6) {
			System.out.println("二等奖");
		} else if (flag && count == 5) {
			System.out.println("三等奖");
		} else if (count == 5 || (flag && count == 4)) {
			System.out.println("四等奖");
		} else if (count == 4 || (flag && count == 3)) {
			System.out.println("五等奖");
		} else if (flag) {
			System.out.println("六等奖");
		} else {
			System.out.println("没有中奖");
		}
	}
	
	public static void main(String[] args) {
		
		RedBlue r=new RedBlue();
		r.getRedBlue();
		r.buyRedBlue();
		r.price(redBlue);
	}
}
