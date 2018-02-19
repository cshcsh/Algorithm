package Test01;

public class RandomNumber {

	public static void main(String[] args) {
		long x=System.nanoTime();
		// TODO Auto-generated method stub
		int a=(int)(Math.random()*2147383647+100000);//100000~2147483647
		System.out.println(a);
		System.out.println((System.nanoTime()-x)+"ns");
	}

}
 