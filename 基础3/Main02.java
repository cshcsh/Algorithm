package date0803;

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[][] a=new int[n][2];
		for(int i=0;i<n;i++){
			for(int j=0;j<2;j++){
				a[i][j]=sc.nextInt();
			}
		}
		int count=0;
		for(int i=0;i<n-2;i++){
			for(int j=i+1;j<n-1;j++){
				for(int k=j+1;k<n;k++){
					if((a[i][0]-a[j][0])*(a[j][1]-a[k][1])!=(a[j][0]-a[k][0])*(a[i][1]-a[j][1])){
						count++;
					}
				}
			}
		}
		System.out.print(count);
	}

}
