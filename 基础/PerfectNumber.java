package Test01;

public class PerfectNumber {

	public int fun(int sum,int k,int j){
		
			if(j<k){
				if(k%j==0){
					return fun(sum+j, k, j+1);
				}else{
					return fun(sum, k, j+1);
				}
			}else{ 
				if(sum==k){
					System.out.println(k);
				}	
			}
		
		return fun(0, k+1, 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectNumber pn=new PerfectNumber();
		pn.fun(0,6,1);
	}
}
