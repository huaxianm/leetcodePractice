
public class AddBinary {
	public static void main(String[] args){
		String a="11";
		String b="1";
		String c="badfqwewqc";
		System.out.println(addBinary(a,b));
		char[] ch=c.toCharArray();
		java.util.Arrays.sort(ch);
		String newone=new String(ch);
		System.out.println(newone);
		int[] array={123,434,12,767,22,999};
		System.out.println(maxProfit(array));
	}
public static int maxProfit(int[] prices) {
        
        int min=0;
        int maxDiff=0;
        int buy=0;
        int sell=0;
        int result;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<prices[min])
                min=i;
                int diff=prices[i]-prices[min];
                if(diff>maxDiff){
                    buy=min;
                    sell=i;
                    maxDiff=diff;
                }
        }
        result=prices[sell]-prices[buy];
        return result;
        
    }
	public static String addBinary(String a, String b) {
	    if(b.indexOf('1')==-1)
	    return a.indexOf('1')==-1?a:a.substring(a.indexOf('1'));
	    int diff=Math.abs(a.length()-b.length());
	    if(a.length()>b.length()){
	        for(int i=0;i<diff;++i)
	        b='0'+b;
	    }
	    else{
	        for(int i=0;i<diff;++i)
	        a='0'+a;
	    }
	    String sum="";
	    String carry="0";
	    for(int i=a.length()-1;i>=0;i--){
	        if( (a.charAt(i) == '1' && b.charAt(i) == '1'))

	                {
	                    if(carry=="0"){
	                        sum="0"+sum;
	                        carry="1";
	                    }
	                    else{
	                        carry="1";
	                        sum="1"+sum;
	                    }
	                }

	            else if(a.charAt(i)=='0'&&b.charAt(i)=='0')
	                {
	                if(carry=="0"){
	                        sum="0"+sum;
	                        carry="0";
	                    }
	                    else{
	                        sum="1"+sum;
	                        carry="0";
	                    }
	                }
	                else if((a.charAt(i)=='1'&&b.charAt(i)=='0')||(a.charAt(i)=='0'&&b.charAt(i)=='1')){
	                    if(carry=="0"){
	                        sum="1"+sum;
	                        carry="0";
	                    }
	                    else{
	                        sum="0"+sum;
	                        carry="1";
	                    }
	                }
	    }
	    sum=carry=="0"?sum:"1"+sum;
	    return sum;
	    }
}
