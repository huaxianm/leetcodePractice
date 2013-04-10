
public class PrimeFibonaciNumber {
	static int[] fib=new int[1000];
	public static void main(String[] args){
		firstprimefibonacci();
		System.out.println(isPrime(281));
	}
	public static void firstprimefibonacci(){
		int n=2;
		while(true){
			int a=fibonacci(n);
			if(a>=227000&&isPrime(a)){
				System.out.println(a);
				break;
			}else{
				n++;
			}
		}
	}
	public static int fibonacci(int i){
		if(i==0) return 0;
		if(i==1) return 1;
		if(fib[i]!=0) return fib[i];
		fib[i]=fibonacci(i-1)+fibonacci(i-2);
		return fib[i];
	}
	
	public static boolean isPrime(int n){
		for(int i=2;i*i<=n;i++){
			if(n%i==0){
				System.out.println(i);
				return false;
			}
		}
		return true;
	}
}
