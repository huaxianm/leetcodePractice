
public class SumToTarget {
	public static void main(String[] args){
		int[] arr={1,2};
		System.out.println(ways(arr,arr.length,5));
	}
	static int ways(int a[], int n, int sum)
	{
	    int[] dp = new int[sum+1];
	    dp[0] = 1;

	    for(int i = 1; i <= sum; i++)
	        dp[i] = 0;
	    
	    for(int i = 0; i < n; i++)
	        for(int x = 1; x <= sum; x++)
	            if(x-a[i]>=0)
	                dp[x] = dp[x - a[i]] + dp[x];
	    
	    return dp[sum];
	}
}
