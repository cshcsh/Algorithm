package Test01;

public class IsPerfectNumber {

	private String isPerfectNumber(int n){
		int i,s=0;
		for(i=1;i<=n;i++){
			if(n%i==0)
				s+=i;
		}
		if(s==n)
			return "YES";
		else return "NO";
		
	}
	
	public static void main(String[] args) {
		long x=System.nanoTime();
		// TODO Auto-generated method stub
		IsPerfectNumber ipn=new IsPerfectNumber();   
		//int型数据能表示最大整数是2147483647
		int a=(int)(Math.random()*2147383647+100000);
		//随机产生一个大于100000的正整数（100000~2147483647）
		//int a=9699690;
		System.out.println(a);
		String str=ipn.isPerfectNumber(a);
		System.out.println(str);
		//System.out.println("Time:"+((System.nanoTime()-x)/1000000)+"ms"+" "+"Memory:"+((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024)+"KB");
	}

}
