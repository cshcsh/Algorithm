package date0806;


public class Test999 {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int n=0;
		for(int i=100;i<=999;i++){
			int a=i/100;
			int b=(i-i/100*100)/10;
			int c=i-i/10*10;
			if(a+b>c&&b+c>a&&c+a>b&&a!=0&&b!=0&&c!=0){
				if(a==b||a==c||b==c){
					
					n++;
				}
			}
		}
		System.out.println(n);
	}

}
