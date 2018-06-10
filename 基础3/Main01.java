package date0803;

import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int of =sc.nextInt();
			int n = sc.nextInt();
			int l1 = sc.nextInt();
			int l2 = sc.nextInt();
			if (l1 > of) {
				if (l1 - of > n) {
					System.out.println(of + " " + (of + n) + " "+0 + " " + 0);
				} else {
					System.out.println(of + " " + l1 + " "+0 + " " + (n - (l1 - of)));
				}
			} else {
				if (n > l2 - of +l1) {
					if(l2<=(of-l1)){
						System.out.println(l1 + " " + l1 + " "+l2 + " " + l2);
					}else{
						System.out.println(l1 + " " + l1 + " "+(of - l1) + " " + l2);
					}
				} else {
					System.out.println(l1 + " " + l1 + " "+(of - l1) + " " + (of - l1 + n));
				}
			}
		}
	}

	
	
}
