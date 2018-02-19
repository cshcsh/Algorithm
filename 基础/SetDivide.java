package Test02;

import java.util.Scanner;

public class SetDivide {

	private int setDivide(int m, int n) {

		if (m == n || m == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		return setDivide(m - 1, n - 1) + n * setDivide(m - 1, n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long x=System.nanoTime();
		int m, n, totalnumber, sum = 0;
		Scanner in = new Scanner(System.in);
		m = in.nextInt(); // 输入元素个数m
		for (int i = 1; i <= m; i++) {
			SetDivide sd = new SetDivide();
			totalnumber = sd.setDivide(m, i);// 子集个数totalnumber
			sum = sum + totalnumber;
		}
		System.out.println(sum);// 输出不同非空集合的子集的个数sum
		System.out.println("Time:"+((System.nanoTime()-x)/1000000)+"ms"+" "+"Memory:"+((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024)+"KB");
	}

}
