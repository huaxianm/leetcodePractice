import java.util.HashMap;


public class DPproblem {
	public static void main(String[] args){
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		System.out.println(climbingstairs(3));
		System.out.println(climbing(4,map));
		System.out.println(makechange(10,10));
		int[] arr={1,2};
		System.out.println(count(arr,5));
		System.out.println(makechange(100,25));
	}
	public static int climbingstairs(int n){
		if(n<0) return 0;
		else if(n==0) return 1;
		else return climbingstairs(n-3)+climbingstairs(n-2)+climbingstairs(n-1);
	}
	public static int climbing(int n,HashMap<Integer,Integer> map){
		if(map.containsKey(n)){
			return map.get(n);
		}
		int q=0;
		if(n<0) return 0;
		else if(n==0) return 1;
		else{
			q=climbing(n-3,map)+climbing(n-2,map)+climbing(n-1,map);
		}
		map.put(n, q);
		return q;
	}
	public static int makechange(int n,int denom){
		int next_denom=0;
		switch(denom){
		case 25:
			next_denom=10;
			break;
		case 10:
			next_denom=5;
			break;
		case 5:
			next_denom=1;
			break;
		case 1:
			return 1;
		}
		int ways=0;
		for(int i=0;i*denom<=n;i++){
			ways+=makechange(n-i*denom,next_denom);
		}
		return ways;
	}
	public static int count(int[] arr, int sum){
		int ways=0;
		if(sum<=0) return 0;
		else if(sum==1) return 1;
		else if(sum==2) return 2;
		else{
			for(int i=0;i<arr.length;i++){
				ways+= count(arr,sum-arr[i]);
			}
		}
		return ways;
	}
}
