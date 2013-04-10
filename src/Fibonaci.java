import java.util.HashSet;


public class Fibonaci {
	public static void main(String[] args){
		System.out.println(findclosest(400));
		for(int i=0;i<20;i++){
			System.out.println(fibonaci(i));
			System.out.println(fibonaciLogN(i));
		}
//		int a=0;
//		int b=1;
//		int n=2;
//		while(true){
//			int temp=a;
//			a=b;
//			b=a+temp;
//			n++;
//			if(b==377){
//				System.out.println("current number is number "+n);
//				break;
//			}	
//			}
//		System.out.println(fibonacinonrecursive(6));
//		}
	}
	public static int fibonaci(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		return fibonaci(n-1)+fibonaci(n-2);
	}
	public static int findclosest(int target){
		if(target==1) return 1;
		int n=2;
		while(true){
			int a=fibonaci(n);
			int b=fibonaci(n+1);
			if(b>=target&&a<=target){
				int a1=Math.abs(a-target);
				int b1=Math.abs(b-target);
					return a1>b1?b:a;
			}
			n++;
		}
	}
	int[] fib=new int[100000];
	int fibonaciefficient(int i){
		if(i==0) return 0;
		if(i==1) return 1;
		if(fib[i]!=0) return fib[i];
		fib[i]=fibonaciefficient(i-1)+fibonaci(i-2);
		return fib[i];
	}
	static int fibonacinonrecursive(int n){
		if(n==0) return 0;
		if(n==1) return 1;
		int[] helper=new int[n+1];
		helper[0]=0;
		helper[1]=1;
		for(int i=2;i<=n;i++){
			helper[i]=helper[i-1]+helper[i-2];
		}
		return helper[n];
	}
	static class Matrix{
		long m00;
		long m01;
		long m10;
		long m11;
		Matrix(){
			m00=0;
			m01=0;
			m10=0;
			m11=0;
		}
		Matrix(long a, long b,long c, long d){
			m00=a;
			m01=b;
			m10=c;
			m11=d;
		}
	}
	static Matrix MatrixMultiply(Matrix a,Matrix b){
		return new Matrix(a.m00*b.m00+a.m01*b.m10,
					  a.m00*b.m01+a.m01*b.m11,
				      a.m10*b.m00+a.m11*b.m10,
				      a.m10*b.m01+a.m11*b.m11);
				      
	}
	static Matrix MatrixPower(int n){
		if(n<=0) return null;
		Matrix matrix=null;
		if(n==1)
			return matrix=new Matrix(1,1,1,0);
		else if(n%2==0){
			matrix=MatrixPower(n/2);
			matrix=MatrixMultiply(matrix,matrix);
		}else if(n%2==1){
			matrix=MatrixPower((n-1)/2);
			matrix=MatrixMultiply(matrix,matrix);
			matrix=MatrixMultiply(matrix,new Matrix(1,1,1,0));
		}
		return matrix;
	}
	static long fibonaciLogN(int n){
		int[] result={0,1};
		if(n<2)
			return result[n];
		Matrix ans=MatrixPower(n-1);
		return ans.m00;
	}

}
