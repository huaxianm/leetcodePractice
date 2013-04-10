
public class BestTimeToSell {
	public static void main(String[] args){
		int[] array={2,1,5,7,6,9};
		System.out.println(maxProfit(array));
	}
	public static int maxProfit(int[] prices) {
	    // Start typing your Java solution below
	    // DO NOT write main() function
	     if(prices==null || prices.length==0)
	        return 0;
	        
	    int len=prices.length;
	    int[] dp1=new int[len];
	    int[] dp2=new int[len];
	    int max=prices[len-1];
	    int min=prices[0];
	    
	    for(int i=1;i<len;i++)
	    {
	        min=Math.min(min,prices[i]);
	        dp1[i]=Math.max(dp1[i-1],prices[i]-min);
	    }
	    for(int i=len-2;i>=0;i--)
	    {
	        max=Math.max(max, prices[i]);
	        dp2[i]=Math.max(dp2[i+1],max-prices[i]);
	    }
	    
	    int ans=0;
	    for(int i=0;i<len;i++)
	        ans=Math.max(ans, dp1[i]+dp2[i]);
	    return ans;
	}
}
